package ru.gb.springbootlesson3.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson3.controllers.restControllers.IssueRequest;
import ru.gb.springbootlesson3.entity.Issue;
import ru.gb.springbootlesson3.repository.BookRepository;
import ru.gb.springbootlesson3.repository.IssueRepository;
import ru.gb.springbootlesson3.repository.ReaderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class IssueService {
    private final BookRepository bookRepository;
    private final IssueRepository issueRepository;
    private final ReaderRepository readerRepository;

    public Issue createIssue(IssueRequest request){
        if (bookRepository.findById(request.getBookId()) == null){
            log.info("Не удалось найти книгу с id " + request.getBookId());
            throw new NoSuchElementException("Не удалось найти книгу с id " + request.getBookId());
        }
        if (readerRepository.findById(request.getReaderId()) == null){
            log.info("Не удалось найти читателя с id " + request.getReaderId());
            throw new NoSuchElementException("Не удалось найти читателя с id " + request.getReaderId());
        }

        if(!issueRepository.ifReaderTookBookAndDontReturn(request.getReaderId())) {
            Issue issue = new Issue(request.getReaderId(), request.getBookId());
            issueRepository.createIssue(issue);
            return issue;
        }
        return null;
    }

    public Issue getById(long id) {
        return issueRepository.getById(id);
    }
    public List<Issue> getAllIssues() {
        return issueRepository.getAllIssues();
    }

    public Issue updateIssue(long issueId) {
        Issue searchIssue = getById(issueId);
        LocalDateTime returnedAt = LocalDateTime.now();
        searchIssue.setTimeReturn(returnedAt);
        return searchIssue;
    }

    public void deleteIssue(long issueId) {
        issueRepository.deleteIssue(issueId);
    }
}
