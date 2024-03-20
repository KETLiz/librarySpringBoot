package ru.gb.springbootlesson3.controllers.htmlControllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.springbootlesson3.entity.Reader;
import ru.gb.springbootlesson3.services.ReaderService;

import java.util.List;

@Controller
@RequestMapping("ui/reader")
public class ReaderController {
    private final ReaderService service;
    public ReaderController(ReaderService service) {
        this.service = service;
    }
    @GetMapping
    public String getAllReaders(Model model) {
        List<Reader> list = service.getAllReaders();
        model.addAttribute("readerList", list);
        return "readers";
    }
}
