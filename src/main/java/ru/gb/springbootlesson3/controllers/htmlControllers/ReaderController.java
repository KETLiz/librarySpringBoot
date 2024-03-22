package ru.gb.springbootlesson3.controllers.htmlControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.springbootlesson3.entity.Issue;
import ru.gb.springbootlesson3.entity.Reader;
import ru.gb.springbootlesson3.services.BookService;
import ru.gb.springbootlesson3.services.IssueService;
import ru.gb.springbootlesson3.services.ReaderService;

import java.util.List;

@Controller
@RequestMapping("ui/reader")
public class ReaderController {
    private final ReaderService readerService;
    private IssueService issueService;
    private BookService bookService;
    public ReaderController(ReaderService readerService, IssueService issueService, BookService bookService) {
        this.readerService = readerService;
        this.issueService = issueService;
        this.bookService = bookService;
    }
    @GetMapping
    public String getAllReaders(Model model) {
        List<Reader> list = readerService.getAllReaders();
        model.addAttribute("readerList", list);
        return "readers";
    }

    @GetMapping("{id}")
    public String bookNameReaderHaveNow(@PathVariable("id") long readerId, Model model) {
        Issue searchIssue = issueService.bookNameReaderHaveNow(readerId);
        long idReader = searchIssue.getIdReader();
        long idBook = searchIssue.getIdBook();
        String readerName = readerService.getReaderNameById(idReader);
        String bookName = bookService.getBookNameById(idBook);
        model.addAttribute("readerId", idReader);
        model.addAttribute("bookId", idBook);
        model.addAttribute("readerName", readerName);
        model.addAttribute("bookName", bookName);
        return "book";
    }
}
