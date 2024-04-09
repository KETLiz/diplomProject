package org.example;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BookRepository {
    private List<Book> books;

    public BookRepository() {
        books = new ArrayList<>();
        books.add(new Book("Война и мир"));
        books.add(new Book("Преступление и наказание"));
        books.add(new Book("Поющие в терновнике"));
        books.add(new Book("Три товарища"));
        books.add(new Book("Триумфальная арка"));
        books.add(new Book("Анна Каренина"));
        books.add(new Book("На западном фронте без перемен"));
        books.add(new Book("Маленькая хозяйка большого дома"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> id == book.getIdBook())
                .findFirst()
                .orElse(null);
    }
}
