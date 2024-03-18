package ru.gb.springbootlesson3.controllers;

import org.springframework.web.bind.annotation.*;
import ru.gb.springbootlesson3.entity.Book;
import ru.gb.springbootlesson3.services.BookService;
import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //метод получения описания книги
    @GetMapping("{id}")
    public Book getBookById(@PathVariable long id) {
        return bookService.findBookById(id);
    }

    //метод удаления книги
//    @DeleteMapping("{id}")
//    public List<Book> removeBook(long id) {
//       return bookService.removeBook(id);
//    }

    //метод добавления новой книги
    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }
}
