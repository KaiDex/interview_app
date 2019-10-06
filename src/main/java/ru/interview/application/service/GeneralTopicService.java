package ru.interview.application.service;

import org.springframework.stereotype.Service;
import ru.interview.application.model.GeneralTopic;
import ru.interview.application.repository.GeneralTopicStorage;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GeneralTopicService {

    private final GeneralTopicStorage storage;

    public GeneralTopicService(GeneralTopicStorage storage) {
        this.storage = storage;
    }

    public List<GeneralTopic> getAll() {
        return storage.findAll();
    }
    public List<GeneralTopic> addTopic(String name) {
        GeneralTopic generalTopic = new GeneralTopic();
        generalTopic.setName(name);
        storage.save(generalTopic);
        return storage.findAll();
    }

}
