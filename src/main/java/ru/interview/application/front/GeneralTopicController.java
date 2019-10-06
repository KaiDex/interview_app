package ru.interview.application.front;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.interview.application.model.GeneralTopic;
import ru.interview.application.service.GeneralTopicService;

import java.util.List;

@RestController
@RequestMapping("/general")
public class GeneralTopicController {

    private final GeneralTopicService generalTopicService;

    public GeneralTopicController(GeneralTopicService generalTopicService) {
        this.generalTopicService = generalTopicService;
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GeneralTopic> getAll() {
        return generalTopicService.getAll();
    }

    @PostMapping(value = "/addTopic", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GeneralTopic> addTopic(String name) {
        return generalTopicService.addTopic(name);
    }
}
