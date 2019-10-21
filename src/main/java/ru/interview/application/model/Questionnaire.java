package ru.interview.application.model;

import lombok.*;
import ru.interview.application.model.dictionary.EntityObject;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Questionnaire extends EntityObject {

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<QuestionnaireEntry> questionnaireEntries;
    private String name;

    private Integer maximumPoints;
    private Integer scoredPoints;
    private Float rating;
}