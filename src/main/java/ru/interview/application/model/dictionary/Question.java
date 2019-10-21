package ru.interview.application.model.dictionary;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Question extends EntityObject implements Serializable {

    private String text;
    private String answer;
    @ManyToOne
    private Topic topic;
    @Enumerated(EnumType.STRING)
    private ComplexityLevel complexityLevel;

    public enum ComplexityLevel {
        EASY,
        MEDIUM,
        HARD
    }
}