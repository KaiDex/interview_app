package ru.interview.application.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
public class Answer {

    private String text;
    private Integer score;

    @Id
    @GeneratedValue
    private Long id;
}
