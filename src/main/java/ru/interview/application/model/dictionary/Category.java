package ru.interview.application.model.dictionary;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Category extends EntityObject implements Serializable {

    private String name;
}