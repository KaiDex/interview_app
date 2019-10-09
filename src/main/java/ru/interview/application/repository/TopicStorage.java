package ru.interview.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.interview.application.model.Topic;

@Repository
public interface TopicStorage extends JpaRepository<Topic, Long> {

}
