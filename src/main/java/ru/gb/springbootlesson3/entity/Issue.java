package ru.gb.springbootlesson3.entity;

import lombok.Data;
import ru.gb.springbootlesson3.repository.BookRepository;

import java.time.LocalDateTime;

@Data
public class Issue {
    private static long genId;

    private final long id;
    private final long idReader;
    private final long idBook;
    private final LocalDateTime issueTime;

    public Issue(long idReader, long idBook){
        id = genId++;
        this.idBook = idBook;
        this.idReader = idReader;
        issueTime = LocalDateTime.now();
    }
}
