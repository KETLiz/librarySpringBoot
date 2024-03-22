package ru.gb.springbootlesson3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson3.controllers.restControllers.BookRequest;
import ru.gb.springbootlesson3.entity.Book;
import ru.gb.springbootlesson3.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> allBooks() {
        return bookRepository.allBooks();
    }

    public Book findBookById(long id) {
        return bookRepository.findById(id);
    }

    public void removeBook(long id) {
        bookRepository.removeBookById(id);
    }

    public Book addNewBook(BookRequest request) {
        Book book = new Book(request.getName());
        bookRepository.addNewBook(book);
        return book;
    }

    public String getBookNameById(long bookId) {
        return bookRepository.findById(bookId).getName();
    }
}
