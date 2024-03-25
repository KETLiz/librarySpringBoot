package ru.gb.springbootlesson3.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson3.controllers.restControllers.IssueRequest;
import ru.gb.springbootlesson3.entity.Book;
import ru.gb.springbootlesson3.entity.Issue;
import ru.gb.springbootlesson3.entity.Reader;
import ru.gb.springbootlesson3.repository.BookRepository;
import ru.gb.springbootlesson3.repository.IssueRepository;
import ru.gb.springbootlesson3.repository.ReaderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class IssueService {
//    @Value("${application.issue.max-allowed-books}")
//    private int maxBookCount;

    private final BookRepository bookRepository;
    private final IssueRepository issueRepository;
    private final ReaderRepository readerRepository;

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public Issue createNewIssue(IssueRequest request) {
        if(readerHaveBooksLessThanTwo(request)) {
            Issue newIssue = new Issue(request.getReaderId(), request.getBookId());
            return issueRepository.save(newIssue);
        }
        return null;
    }

    public boolean readerHaveBooksLessThanTwo(IssueRequest request) {
        long readerIdFromRequest = request.getReaderId();
        List<Issue> issues = getAllIssues();
        List<Issue> issuesByReaderFromRequest = new ArrayList<>();
        for(Issue i : issues) {
            if(i.getIdReader() == readerIdFromRequest && i.getReturnedAt() == null) {
                issuesByReaderFromRequest.add(i);
            }
        }
        return issuesByReaderFromRequest.size() < 2;
    }

    public void returnBook(long issueId) {
        Issue searchIssue = issueRepository.findById(issueId).orElseThrow();
        LocalDateTime returnedAt = LocalDateTime.now();
        searchIssue.setTimeReturn(returnedAt);
//        long searchBookId = searchIssue.getIdBook();
//        Book searchBook = bookRepository.findById(searchBookId).orElseThrow();
//        long searchReaderId = searchIssue.getIdReader();
//        Reader searchReader =
    }
//    public Issue createIssue(IssueRequest request){
//        if (bookRepository.findById(request.getBookId()) == null){
//            log.info("Не удалось найти книгу с id " + request.getBookId());
//            throw new NoSuchElementException("Не удалось найти книгу с id " + request.getBookId());
//        }
//        if (readerRepository.findById(request.getReaderId()) == null){
//            log.info("Не удалось найти читателя с id " + request.getReaderId());
//            throw new NoSuchElementException("Не удалось найти читателя с id " + request.getReaderId());
//        }
//        if(!issueRepository.ifReaderTookBookAndDontReturn(request.getReaderId())) {
//            Issue issue = new Issue(request.getReaderId(), request.getBookId());
//            issueRepository.createIssue(issue);
//            return issue;
//        }
//        return null;
//    }
//
//    public Issue getById(long id) {
//        return issueRepository.getById(id);
//    }
//    public List<Issue> getAllIssues() {
//        return issueRepository.getAllIssues();
//    }
//
//    public Issue updateIssue(long issueId) {
//        Issue searchIssue = getById(issueId);
//        LocalDateTime returnedAt = LocalDateTime.now();
//        searchIssue.setTimeReturn(returnedAt);
//        return searchIssue;
//    }
//
//    public Issue bookNameReaderHaveNow(long readerId) {
//        return issueRepository.bookNameReaderHaveNow(readerId);
//    }
}
