package ru.gb.springbootlesson3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson3.entity.Book;
import ru.gb.springbootlesson3.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book findBookById(long id) {
        return bookRepository.findById(id);
    }

    public List<Book> removeBook(long id) {
        return bookRepository.removeBookById(id);
    }

    public void addBook(Book book) {
        bookRepository.addNewBook(book);
    }
}
