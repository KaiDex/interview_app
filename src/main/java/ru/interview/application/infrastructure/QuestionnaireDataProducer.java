package ru.interview.application.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.interview.application.model.Questionnaire;
import ru.interview.application.model.QuestionnaireEntry;
import ru.interview.application.model.dictionary.Question;
import ru.interview.application.service.QuestionnaireEntryService;

import java.util.Set;

@Component
public class QuestionnaireDataProducer {

    @Autowired
    private QuestionnaireEntryService questionnaireEntryService;

    private static final String QUESTIONNAIRE_NAME = "Вопросник номер 1";

    public Questionnaire produceQuestionnaire(Set<Question> questions) {
        Questionnaire questionnaire = questionnaireEntryService.create(QUESTIONNAIRE_NAME);
        questions.forEach(question -> addEntry(questionnaire, question));
        return questionnaire;
    }

    private Set<QuestionnaireEntry> addEntry(Questionnaire questionnaire, Question question) {
        return questionnaireEntryService.addEntry(questionnaire.getId(), question.getId());
    }
}
