package org.example;

import lombok.Data;

import java.util.UUID;

@Data
public class Issue {
    private UUID idIssue;
    private int idBook;
    private int idReader;

}
