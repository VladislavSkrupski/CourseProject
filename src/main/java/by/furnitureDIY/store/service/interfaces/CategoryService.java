package by.furnitureDIY.store.service.interfaces;

import by.furnitureDIY.store.service.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    List<CategoryDto> getAll();

    List<CategoryDto> getAllWithoutMaterials();

    CategoryDto findById(Integer id);

    CategoryDto findByIdWithoutMaterials(Integer id);

    CategoryDto deleteById(Integer id);

    CategoryDto create(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto);
}
