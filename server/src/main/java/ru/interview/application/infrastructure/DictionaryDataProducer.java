package ru.interview.application.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.interview.application.model.dictionary.Category;
import ru.interview.application.model.dictionary.Question;
import ru.interview.application.model.dictionary.Topic;
import ru.interview.application.service.dictionary.CategoryService;
import ru.interview.application.service.dictionary.QuestionService;
import ru.interview.application.service.dictionary.TopicService;
import ru.interview.application.service.dto.TopicAndAnswer;

import java.util.HashSet;
import java.util.Set;

@Component
public class DictionaryDataProducer {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private TopicService topicService;

    private static final String CATEGORIES_JAVA_CORE = "Java Core";
    private static final String CATEGORIES_SPRING = "Spring";

    private static final String TOPIC_COLLECTIONS = "Collections";
    private static final String TOPIC_EXCEPTIONS = "Exceptions";
    private static final String TOPIC_TRANSACTIONS = "Transactions";
    private static final String TOPIC_COMPONENTS = "Components";

    public Set<Category> produceCategories() {
        HashSet<Category> result = new HashSet<>();
        result.add(categoryService.create(CATEGORIES_JAVA_CORE));
        result.add(categoryService.create(CATEGORIES_SPRING));
        return result;
    }

    public Set<Topic> produceTopics(Set<Category> categories) {
        HashSet<Topic> result = new HashSet<>();
        categories.forEach(category -> {
            if (category.getName().equals(CATEGORIES_JAVA_CORE)) {
                result.add(topicService.create(TOPIC_COLLECTIONS, category));
                result.add(topicService.create(TOPIC_EXCEPTIONS, category));
            } else if ((category.getName().equals(CATEGORIES_SPRING))) {
                result.add(topicService.create(TOPIC_TRANSACTIONS, category));
                result.add(topicService.create(TOPIC_COMPONENTS, category));
            }
        });
        return result;
    }

    public Set<Question> produceQuestions(Set<Topic> topics) {
        HashSet<Question> result = new HashSet<>();
        topics.forEach(topic -> {
            Question question = null;
            TopicAndAnswer topicAndAnswer = TopicAndAnswer.builder().build();
            switch (topic.getName()) {
                case TOPIC_COLLECTIONS:
                    topicAndAnswer = TopicAndAnswer.builder()
                            .topic(topic)
                            .answer("Список, множество, очередь.")
                            .build();
                    question = questionService.create("Типы коллекций в Java?", topicAndAnswer);
                    break;
                case TOPIC_EXCEPTIONS:
                    topicAndAnswer = TopicAndAnswer.builder()
                            .topic(topic)
                            .answer("Checked, unchecked, error.")
                            .build();
                    question = questionService.create("Типы исключений в Java?", topicAndAnswer);
                    break;
                case TOPIC_TRANSACTIONS:
                    topicAndAnswer = TopicAndAnswer.builder()
                            .topic(topic)
                            .answer("Выбросить Runtime исключение.")
                            .build();
                    question = questionService.create("Как откатить результаты декларативной транзакции?", topicAndAnswer);
                    break;
                case TOPIC_COMPONENTS:
                    topicAndAnswer = TopicAndAnswer.builder()
                            .topic(topic)
                            .answer("Синглтон, прототайп")
                            .build();
                    question = questionService.create("Виды бинов в Spring?", topicAndAnswer);
                    break;
            }
            result.add(question);
        });
        return result;
    }
}
