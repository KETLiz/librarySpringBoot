package ru.gb.springbootlesson3.controllers.restControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbootlesson3.entity.Issue;
import ru.gb.springbootlesson3.entity.Reader;
import ru.gb.springbootlesson3.services.ReaderService;

import java.util.List;

@RestController
@RequestMapping("reader")
public class ReaderRestController {
    private ReaderService service;

    public ReaderRestController(ReaderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reader> getAllReaders() {
        return service.getAllReaders();
    }

    @GetMapping("{id}")
    public Reader getReaderById(@PathVariable long id) {
        return service.getReaderById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Reader> deleteReaderById(@PathVariable long id) {
        if(service.existsReaderById(id)) {
            service.deleteReaderbyId(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Reader createNewReader(@RequestBody ReaderRequest request) {
        return service.createNewReader(request);
    }
//    @GetMapping
//    public List<Reader> getAllReaders() {
//        return service.getAllReaders();
//    }
//
//    @GetMapping("{id}")
//    public Reader getReaderById(@PathVariable long id) {
//        return service.getReaderByid(id);
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<Void> deleteReader(@PathVariable Long id) {
//        service.deleteReader(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<Reader> createNewReader(@RequestBody ReaderRequest request) {
//        try {
//            return ResponseEntity.status(HttpStatus.CREATED).body(service.createReader(request));
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @GetMapping("{id}/issue")
//    public List<Issue> issuesByReaderId(@PathVariable("id") long readerId) {
//        return service.getIssuesByReaderId(readerId);
//    }
}
