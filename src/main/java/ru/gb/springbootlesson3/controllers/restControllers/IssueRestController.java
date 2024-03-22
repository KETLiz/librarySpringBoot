package ru.gb.springbootlesson3.controllers.restControllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbootlesson3.entity.Issue;
import ru.gb.springbootlesson3.services.IssueService;

import java.net.HttpURLConnection;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("issue")
@RequiredArgsConstructor
public class IssueRestController {

    @Autowired
    private IssueService service;

//    @PostMapping
//    public int issueBook(@RequestBody IssueRequest issueRequest) {
//        log.info("Поступил запрос на выдачу: readerId={}, bookId={}"
//                , issueRequest.getReaderId(), issueRequest.getBookId());
//
//        try {
//            if(service.createIssue(issueRequest) != null) {
//                return HttpURLConnection.HTTP_CREATED;
//            } else {
//                return HttpURLConnection.HTTP_CONFLICT;
//            }
//
//            //return ResponseEntity.status(HttpStatus.CREATED).body(service.createIssue(issueRequest));
//        } catch (NoSuchElementException e){
//            return HttpURLConnection.HTTP_GATEWAY_TIMEOUT;
//        }
//    }

    @PostMapping
    public ResponseEntity<Issue> issueBookResponse(@RequestBody IssueRequest issueRequest) {
        try {
            if(service.createIssue(issueRequest) != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(service.createIssue(issueRequest));
            }
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return null;
    }

    @GetMapping
    @RequestMapping("{id}")
    public Issue getBookById(@PathVariable long id) {
        return service.getById(id);
    }

    @PutMapping("{issueId}")
    public ResponseEntity<Issue> updateIssue(@PathVariable long issueId) {
        Issue searchIssue = service.updateIssue(issueId);
        //service.updateIssue(issueId);
        //return new ResponseEntity<>(HttpStatus.OK);
        return ResponseEntity.status(HttpStatus.OK).body(searchIssue);
    }

}
