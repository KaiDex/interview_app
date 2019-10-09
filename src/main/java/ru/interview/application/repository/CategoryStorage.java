package ru.interview.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.interview.application.model.Category;

@Repository
public interface CategoryStorage extends JpaRepository<Category, Long> {

}
