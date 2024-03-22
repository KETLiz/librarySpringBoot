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
    private final LocalDateTime issuedAt;
    private LocalDateTime returnedAt = null;

    public Issue(long idReader, long idBook){
        id = genId++;
        this.idBook = idBook;
        this.idReader = idReader;
        issuedAt = LocalDateTime.now();
    }

    public void setTimeReturn(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
    }

}
