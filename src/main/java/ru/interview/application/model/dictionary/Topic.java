package ru.interview.application.model.dictionary;

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
public class Topic extends EntityObject implements Serializable {

    private String name;
    @ManyToOne
    private Category category;
}