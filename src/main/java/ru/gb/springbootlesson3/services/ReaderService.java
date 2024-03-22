package ru.gb.springbootlesson3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson3.controllers.restControllers.ReaderRequest;
import ru.gb.springbootlesson3.entity.Book;
import ru.gb.springbootlesson3.entity.Issue;
import ru.gb.springbootlesson3.entity.Reader;
import ru.gb.springbootlesson3.repository.IssueRepository;
import ru.gb.springbootlesson3.repository.ReaderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;
    private final ReaderRepository bookRepository;


    public List<Reader> getAllReaders() {
        return readerRepository.getAllReaders();
    }

    public Reader getReaderByid(long id) {
        return readerRepository.findById(id);
    }

    public void deleteReader(Long id) {
        readerRepository.deleteReader(id);
    }

    public Reader createReader(ReaderRequest request) {
        Reader newReader = new Reader(request.getName());
        readerRepository.createReader(newReader);
        return newReader;
    }

    public List<Issue> getIssuesByReaderId(long readerId) {
        return issueRepository.takenBooksByRederId(readerId);
    }

    public String getReaderNameById(long readerId) {
        return readerRepository.findById(readerId).getName();
    }
}
