package ru.interview.application.front.dictionary;

import org.springframework.web.bind.annotation.*;
import ru.interview.application.model.dictionary.Category;
import ru.interview.application.model.dictionary.Topic;
import ru.interview.application.service.dictionary.TopicService;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {

    private final TopicService TopicService;

    public TopicController(TopicService TopicService) {
        this.TopicService = TopicService;
    }

    @GetMapping(value = "/getAll")
    public List<Topic> getAll() {
        return TopicService.getAll();
    }

    @PostMapping(value = "/create")
    public Topic create(String name, @RequestBody Category category) {
        return TopicService.create(name, category);
    }

    @GetMapping(value = "/find")
    public Topic find(Long id) {
        return TopicService.find(id);
    }

    @PostMapping("/update")
    public Topic update(Topic Topic) {
        return TopicService.update(Topic);
    }

    @GetMapping("/delete")
    public void delete(Long id) {
        TopicService.delete(id);
    }
}
