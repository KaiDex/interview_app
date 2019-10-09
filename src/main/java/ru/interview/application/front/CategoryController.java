package ru.interview.application.front;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.interview.application.model.Category;
import ru.interview.application.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/getAll")
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping(value = "/create")
    public List<Category> create(String name) {
        return categoryService.create(name);
    }

    @GetMapping(value = "/find")
    public Category find(Long id) {
        return categoryService.find(id);
    }

    @PostMapping("/update")
    public Category update(Category category) {
        return categoryService.update(category);
    }

    @GetMapping("/delete")
    public void delete(Long id) {
        categoryService.delete(id);
    }
}
