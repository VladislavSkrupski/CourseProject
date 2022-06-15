package by.furnitureDIY.store.service;

import by.furnitureDIY.store.dao.entity.Category;
import by.furnitureDIY.store.dao.repository.CategoryOnlyRepository;
import by.furnitureDIY.store.dao.repository.CategoryRepository;
import by.furnitureDIY.store.service.dto.CategoryDto;
import by.furnitureDIY.store.service.interfaces.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryOnlyRepository categoryOnlyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryOnlyRepository categoryOnlyRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.categoryOnlyRepository = categoryOnlyRepository;
    }

    @Override
    @Transactional
    public List<CategoryDto> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return convertListEntitiesToListDtos(categories);
    }

    @Override
    @Transactional
    public List<CategoryDto> getAllWithoutMaterials() {
        List<Category> categories = categoryOnlyRepository.findAll();
        return convertListEntitiesToListDtosWithoutMaterials(categories);
    }

    @Override
    @Transactional
    public CategoryDto findById(Integer id) {
        Category category = categoryRepository.getById(id);
        return convertEntityToDto(category);
    }

    @Override
    @Transactional
    public CategoryDto findByIdWithoutMaterials(Integer id) {
        Category category = categoryOnlyRepository.getById(id);
        return convertEntityToDto(withoutMaterials(category));
    }

    @Override
    @Transactional
    public CategoryDto deleteById(Integer id) {
        Category category;
        if (categoryRepository.existsById(id)) {
            category = categoryRepository.getById(id);
            categoryRepository.deleteById(id);
        } else {
            category = null;
        }
        return convertEntityToDto(category);
    }

    @Override
    @Transactional
    public CategoryDto create(CategoryDto categoryDto) {
        return convertEntityToDto(categoryRepository.save(convertDtoToEntity(categoryDto)));
    }

    @Override
    @Transactional
    public CategoryDto update(CategoryDto categoryDto) {
        return convertEntityToDto(categoryRepository.save(convertDtoToEntity(categoryDto)));
    }


    //----------------------------------Convert methods-----------------------------------------
    private List<CategoryDto> convertListEntitiesToListDtos(List<Category> entities) {
        List<CategoryDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(convertEntityToDto(entity)));
        return dtos;
    }

    private List<CategoryDto> convertListEntitiesToListDtosWithoutMaterials(List<Category> entities) {
        List<CategoryDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(convertEntityToDto(withoutMaterials(entity))));
        return dtos;
    }

    private List<Category> convertListDtosToListEntities(List<CategoryDto> dtos) {
        List<Category> entities = new ArrayList<>();
        dtos.forEach(dto -> entities.add(convertDtoToEntity(dto)));
        return entities;
    }

    private CategoryDto convertEntityToDto(Category entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, CategoryDto.class);
    }

    private Category convertDtoToEntity(CategoryDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Category.class);
    }

    private Category withoutMaterials(Category entity) {
        modelMapper.typeMap(Category.class, Category.class).addMappings(mapper -> mapper.skip(Category::setMaterials));
        return modelMapper.map(entity, Category.class);
    }
}
