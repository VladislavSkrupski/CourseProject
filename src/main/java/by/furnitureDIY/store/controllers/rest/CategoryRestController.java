package by.furnitureDIY.store.controllers.rest;

import by.furnitureDIY.store.service.dto.CategoryDto;
import by.furnitureDIY.store.service.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("categories")
public class CategoryRestController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public List<CategoryDto> getCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable(name = "id") int id) {
        return categoryService.findById(id);
    }

    @GetMapping("/only")
    public List<CategoryDto> getCategoriesOnly() {
        return categoryService.getAllWithoutMaterials();
    }

    @GetMapping("/only/{id}")
    public CategoryDto getCategoryByIdOnly(@PathVariable(name = "id") int id) {
        return categoryService.findByIdWithoutMaterials(id);
    }

    @PostMapping("")
    public CategoryDto postCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.create(categoryDto);
    }

    @DeleteMapping("/{id}")
    public CategoryDto deleteCategoryById(@PathVariable(name = "id") int id) {
        return categoryService.deleteById(id);
    }

}
