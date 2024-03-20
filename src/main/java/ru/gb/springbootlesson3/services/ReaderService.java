package ru.gb.springbootlesson3.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.springbootlesson3.entity.Reader;
import ru.gb.springbootlesson3.repository.ReaderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final ReaderRepository repository;

    public List<Reader> getAllReaders() {
        return repository.getAllReaders();
    }

    public Reader getReaderByid(long id) {
        return repository.findById(id);
    }

    public void deleteReader(Long id) {
        repository.deleteReader(id);
    }

    public Reader createReader(Reader reader) {
        repository.createReader(reader);
        return reader;
    }
}
