package ru.interview.application.service;

import org.springframework.stereotype.Service;
import ru.interview.application.model.Category;
import ru.interview.application.repository.CategoryStorage;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final CategoryStorage storage;

    public CategoryService(CategoryStorage storage) {
        this.storage = storage;
    }

    public List<Category> getAll() {
        return storage.findAll();
    }

    public List<Category> create(String name) {
        Category category = Category.builder()
                .name(name)
                .build();
        storage.save(category);
        return storage.findAll();
    }

    public Category find(Long id) {
        return storage.findById(id).orElseThrow(() -> new IllegalArgumentException("Не найдена сущность с заданным id"));
    }

    public Category update(Category category) {
        return storage.save(category);
    }

    public void delete(Long id) {
        storage.deleteById(id);
    }

}
