package org.example;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class IssueRepository {
    private List<Issue> issues;
    private BookProvider provider;

    public IssueRepository(BookProvider provider) {
        issues = new ArrayList<>();
        this.provider = provider;
        for(int i = 1; i < 9; i++) {
            Issue issue = new Issue();
            issue.setIdIssue(UUID.randomUUID());
            issue.setIdBook(provider.getBookId(i));
            issue.setIdReader(i);

            issues.add(issue);
        }
    }

    public List<Issue> getAllIssues() {
        return issues;
    }
}
