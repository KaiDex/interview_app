package ru.interview.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.interview.application.model.Question;

@Repository
public interface QuestionStorage extends JpaRepository<Question, Long> {
}
