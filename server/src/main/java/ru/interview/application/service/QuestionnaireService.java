package ru.interview.application.service;

import org.springframework.stereotype.Service;
import ru.interview.application.model.Questionnaire;
import ru.interview.application.repository.QuestionnaireStorage;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuestionnaireService {

    protected final QuestionnaireStorage storage;

    public QuestionnaireService(QuestionnaireStorage storage) {
        this.storage = storage;
    }

    public List<Questionnaire> getAll() {
        return storage.findAll();
    }

    public Questionnaire create(String name) {
        Questionnaire questionnaire = Questionnaire.builder()
                .name(name)
                .build();
        return storage.save(questionnaire);
    }

    public Questionnaire find(Long id) {
        return storage.findById(id).orElseThrow(() -> new IllegalArgumentException("Не найдена сущность с заданным id"));
    }

    public Questionnaire update(Questionnaire category) {
        return storage.save(category);
    }

    public void delete(Long id) {
        storage.deleteById(id);
    }

}
