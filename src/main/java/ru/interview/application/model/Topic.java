package ru.interview.application.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Topic {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private GeneralTopic generalTopic;
}
