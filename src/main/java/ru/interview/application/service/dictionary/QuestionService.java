package ru.interview.application.service.dictionary;

import org.springframework.stereotype.Service;
import ru.interview.application.model.dictionary.Question;
import ru.interview.application.repository.QuestionStorage;
import ru.interview.application.service.dto.TopicAndAnswer;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class QuestionService {

    private final QuestionStorage storage;

    public QuestionService(QuestionStorage storage) {
        this.storage = storage;
    }

    public List<Question> getAll() {
        return storage.findAll();
    }

    public Question create(String text, TopicAndAnswer topicAndAnswer) {
        Question category = Question.builder()
                .text(text)
                .topic(topicAndAnswer.getTopic())
                .answer(topicAndAnswer.getAnswer())
                .build();
        return storage.save(category);
    }

    public Question find(Long id) {
        return storage.findById(id).orElseThrow(() -> new IllegalArgumentException("Не найдена сущность с заданным id"));
    }

    public Question update(Question category) {
        return storage.save(category);
    }

    public void delete(Long id) {
        storage.deleteById(id);
    }

}
