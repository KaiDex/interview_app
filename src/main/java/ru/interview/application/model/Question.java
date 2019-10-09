package ru.interview.application.model;

import lombok.*;

import javax.persistence.Entity;
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
}