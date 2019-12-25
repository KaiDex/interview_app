package ru.interview.application.service;

import org.springframework.stereotype.Service;
import ru.interview.application.model.Questionnaire;
import ru.interview.application.model.QuestionnaireEntry;
import ru.interview.application.model.dictionary.Question;
import ru.interview.application.repository.QuestionnaireStorage;
import ru.interview.application.service.dictionary.QuestionService;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class QuestionnaireEntryService extends QuestionnaireService {

    private QuestionService questionService;

    public QuestionnaireEntryService(QuestionnaireStorage storage, QuestionService questionService) {
        super(storage);
        this.questionService = questionService;
    }

    public Set<QuestionnaireEntry> findAllEntries(Long questionnaireId) {
        return storage.findById(questionnaireId)
                .map(Questionnaire::getQuestionnaireEntries)
                .orElseThrow(() -> new IllegalArgumentException("Не найдена сущность с заданным id"));
    }

    public Set<QuestionnaireEntry> addEntry(Long questionnaireId, Long questionId) {
        Question question = questionService.find(questionId);
        QuestionnaireEntry entry = QuestionnaireEntry.builder()
                .question(question)
                .build();
        Questionnaire questionnaire = find(questionnaireId);
        questionnaire.getQuestionnaireEntries().add(entry);
        storage.save(questionnaire);
        return findAllEntries(questionnaireId);
    }

    public QuestionnaireEntry findEntry(Long questionnaireId, Long entryId) {
        return findAllEntries(questionnaireId).stream()
                .filter(entry -> entryId.equals(entry.getId()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Не найдена сущность с заданным id"));
    }

    public Questionnaire editEntry(Long questionnaireId, QuestionnaireEntry entry) {
        Questionnaire questionnaire = find(questionnaireId);
        questionnaire.getQuestionnaireEntries().add(entry);
        return storage.save(questionnaire);
    }

    public Set<QuestionnaireEntry> removeEntry(Long questionnaireId, Long entryId) {
        Questionnaire questionnaire = find(questionnaireId);
        questionnaire.getQuestionnaireEntries()
                .removeIf(entry -> entryId.equals(entry.getId()));
        storage.save(questionnaire);
        return findAllEntries(questionnaireId);
    }

}
