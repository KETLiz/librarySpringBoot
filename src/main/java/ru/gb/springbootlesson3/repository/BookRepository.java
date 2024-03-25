package ru.gb.springbootlesson3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.gb.springbootlesson3.entity.Book;
import ru.gb.springbootlesson3.entity.Issue;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//    private List<Book> list = new ArrayList<>();
//
//    public BookRepository() {
//        list.add(new Book("Война и мир"));
//        list.add(new Book("Мастер и Маргарита"));
//        list.add(new Book("Приключения Буратино"));
//    }
//
//    public Book findById(long id){
//        return list.stream().filter(e -> e.getId() == id)
//                .findFirst()
//                .orElse(null);
//    }
//
//    public void removeBookById(long id) {
//        list.removeIf(book -> book.getId() == id);
//    }
//
//    public void addNewBook(Book book) {
//        list.add(book);
//    }
//
//    public List<Book> allBooks() {
//        return list;
//    }

}
