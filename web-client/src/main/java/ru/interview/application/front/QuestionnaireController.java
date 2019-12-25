package ru.interview.application.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.interview.application.model.Questionnaire;
import ru.interview.application.service.QuestionnaireEntryService;

import java.util.List;

@RestController
@RequestMapping("/questionnaire")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireEntryService questionnaireEntryService;

    @GetMapping(value = "/getAll")
    public List<Questionnaire> getAll() {
        return questionnaireEntryService.getAll();
    }
}
