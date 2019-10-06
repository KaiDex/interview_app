package ru.interview.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.interview.application.model.GeneralTopic;

@Repository
public interface TopicStorage extends JpaRepository<GeneralTopic, Long> {

}
