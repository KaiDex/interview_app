package ru.interview.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.interview.application.model.Questionnaire;

@Repository
public interface QuestionnaireStorage extends JpaRepository<Questionnaire, Long> {
}
