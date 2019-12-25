package ru.interview.application.service.dictionary;

import org.springframework.stereotype.Service;
import ru.interview.application.model.dictionary.Category;
import ru.interview.application.model.dictionary.Topic;
import ru.interview.application.repository.TopicStorage;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TopicService {

    private final TopicStorage storage;

    public TopicService(TopicStorage storage) {
        this.storage = storage;
    }

    public List<Topic> getAll() {
        return storage.findAll();
    }

    public Topic create(String name, Category category) {
        Topic topic = Topic.builder()
                .name(name)
                .category(category)
                .build();
        return storage.save(topic);
    }

    public Topic find(Long id) {
        return storage.findById(id).orElseThrow(() -> new IllegalArgumentException("Не найдена сущность с заданным id"));
    }

    public Topic update(Topic Topic) {
        return storage.save(Topic);
    }

    public void delete(Long id) {
        storage.deleteById(id);
    }

}
