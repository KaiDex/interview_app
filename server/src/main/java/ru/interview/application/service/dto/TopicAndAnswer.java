package ru.interview.application.service.dto;

import lombok.*;
import ru.interview.application.model.dictionary.Topic;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TopicAndAnswer implements Serializable {

    private Topic topic;
    private String answer;
}