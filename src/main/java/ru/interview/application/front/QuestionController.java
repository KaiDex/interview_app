package ru.interview.application.front;

import org.springframework.web.bind.annotation.*;
import ru.interview.application.model.Question;
import ru.interview.application.service.QuestionService;
import ru.interview.application.service.dto.TopicAndAnswer;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService QuestionService) {
        this.questionService = QuestionService;
    }

    @GetMapping(value = "/getAll")
    public List<Question> getAll() {
        return questionService.getAll();
    }

    @PostMapping(value = "/create")
    public List<Question> create(String text, @RequestBody TopicAndAnswer topicAndAnswer) {
        return questionService.create(text, topicAndAnswer);
    }

    @GetMapping(value = "/find")
    public Question find(Long id) {
        return questionService.find(id);
    }

    @PostMapping("/update")
    public Question update(Question Question) {
        return questionService.update(Question);
    }

    @GetMapping("/delete")
    public void delete(Long id) {
        questionService.delete(id);
    }
}
