package org.example;

import lombok.Data;

@Data
public class Book {
    private static int id = 1;
    private int idBook;
    private String name;

    public Book(String name) {
        idBook = id++;
        this.name = name;
    }
}
