package ru.interview.application.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
public class Question {

    @Id
    @GeneratedValue
    private Long id;
    private String text;
    @OneToOne
    private Answer answer;
    @ManyToOne
    private Topic topic;
}
