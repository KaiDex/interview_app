package ru.interview.application.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ru.interview.application.model.dictionary.Category;
import ru.interview.application.model.dictionary.Question;
import ru.interview.application.model.dictionary.Topic;

import java.util.Set;

@Component
@ConditionalOnProperty(value = "load_data", havingValue = "true")
public class TestDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private DictionaryDataProducer dictionaryDataProducer;
    @Autowired
    private QuestionnaireDataProducer questionnaireDataProducer;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Set<Category> categories = dictionaryDataProducer.produceCategories();
        Set<Topic> topics = dictionaryDataProducer.produceTopics(categories);
        Set<Question> questions = dictionaryDataProducer.produceQuestions(topics);

        questionnaireDataProducer.produceQuestionnaire(questions);
    }
}
