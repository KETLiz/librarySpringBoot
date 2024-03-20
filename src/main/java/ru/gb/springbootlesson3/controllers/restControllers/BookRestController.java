package ru.gb.springbootlesson3.controllers.restControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springbootlesson3.entity.Book;
import ru.gb.springbootlesson3.services.BookService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("book")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
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
    public ResponseEntity<Book> addBook(@RequestBody BookRequest bookRequest) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addNewBook(bookRequest));
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

}
