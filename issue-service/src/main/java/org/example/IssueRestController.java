package org.example;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("issues")
public class IssueRestController {
    private final IssueRepository repository;
    @GetMapping
    public List<Issue> getAllIssues() {
        return repository.getAllIssues();
    }
}
