package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("books")
public class BookRestController {
    private final BookRepository repository;

    @GetMapping
    public List<Book> getAllBooks() {
        return repository.getAllBooks();
    }

    @GetMapping("{id}")
    public Book getBookById(@PathVariable int id) {
        return repository.getBookById(id);
    }
}
