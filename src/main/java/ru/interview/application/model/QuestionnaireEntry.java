package ru.interview.application.model;

import lombok.*;
import ru.interview.application.model.dictionary.EntityObject;
import ru.interview.application.model.dictionary.Question;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class QuestionnaireEntry extends EntityObject {

    @OneToOne(cascade = CascadeType.ALL)
    private Question question;
    private Integer score;
}