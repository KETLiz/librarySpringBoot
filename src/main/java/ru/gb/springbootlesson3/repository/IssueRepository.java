package ru.gb.springbootlesson3.repository;

import org.springframework.stereotype.Repository;
import ru.gb.springbootlesson3.entity.Issue;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueRepository {
    private List<Issue> list = new ArrayList<>();

    public void createIssue(Issue issue){
        list.add(issue);
    }

    public Issue getById(long id) {
        return list.stream()
                .filter(issue -> issue.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean ifReaderTookBookAndDontReturn(long readerId) {
        for(Issue issue : list) {
            if(issue.getIdReader() == readerId && issue.getReturnedAt() == null) {
                return true;
            }
        }
        return false;
    }

    public List<Issue> takenBooksByRederId(long readerId) {
        List<Issue> issuesByReaderId = new ArrayList<>();
        for(Issue issue : list) {
            if(ifReaderTookBookAndDontReturn(readerId)) {
                issuesByReaderId.add(issue);
            }
        }
        return issuesByReaderId;
    }

    public List<Issue> getAllIssues() {
        return list;
    }
    public void deleteIssue(long issueId) {
         list.removeIf(issue -> issue.getId() == issueId);
    }
}
