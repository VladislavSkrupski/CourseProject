package by.furnitureDIY.store.service;

import by.furnitureDIY.store.dao.entity.Brand;
import by.furnitureDIY.store.dao.repository.BrandOnlyRepository;
import by.furnitureDIY.store.dao.repository.BrandRepository;
import by.furnitureDIY.store.service.dto.BrandDto;
import by.furnitureDIY.store.service.interfaces.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final BrandOnlyRepository brandOnlyRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, BrandOnlyRepository brandOnlyRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.brandOnlyRepository = brandOnlyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<BrandDto> getAll() {
        List<Brand> brands = brandRepository.findAll();
        return convertListEntitiesToListDtos(brands);
    }

    @Override
    @Transactional
    public List<BrandDto> getAllWithoutMaterials() {
        List<Brand> brands = brandOnlyRepository.findAll();
        return convertListEntitiesToListDtosWithoutMaterials(brands);
    }

    @Override
    @Transactional
    public BrandDto findById(Integer id) {
        Brand brand = brandRepository.getById(id);
        return convertEntityToDto(brand);
    }

    @Override
    @Transactional
    public BrandDto findByBrand(String brandName) {
        Brand brand = brandRepository.getByBrand(brandName);
        return convertEntityToDto(brand);
    }

    @Override
    @Transactional
    public BrandDto findByBrandWithoutMaterials(String brandName) {
        Brand brand = brandOnlyRepository.getByBrand(brandName);
        return convertEntityToDto(brand);
    }


    @Override
    @Transactional
    public BrandDto findByIdWithoutMaterials(Integer id) {
        Brand brand = brandOnlyRepository.getById(id);
        return convertEntityToDto(withoutMaterials(brand));
    }

    @Override
    @Transactional
    public BrandDto deleteById(Integer id) {
        Brand brand;
        if (brandRepository.existsById(id)) {
            brand = brandRepository.getById(id);
            brandRepository.deleteById(id);
        } else {
            brand = null;
        }
        return convertEntityToDto(brand);
    }

    @Override
    @Transactional
    public BrandDto create(BrandDto brandDto) {
        return convertEntityToDto(brandRepository.save(convertDtoToEntity(brandDto)));
    }

    @Override
    @Transactional
    public BrandDto update(BrandDto brandDto) {
        return convertEntityToDto(brandRepository.save(convertDtoToEntity(brandDto)));
    }


    //----------------------------------Convert methods-----------------------------------------
    private List<BrandDto> convertListEntitiesToListDtos(List<Brand> entities) {
        List<BrandDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(convertEntityToDto(entity)));
        return dtos;
    }

    private List<BrandDto> convertListEntitiesToListDtosWithoutMaterials(List<Brand> entities) {
        List<BrandDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(convertEntityToDto(withoutMaterials(entity))));
        return dtos;
    }

    private List<Brand> convertListDtosToListEntities(List<BrandDto> dtos) {
        List<Brand> entities = new ArrayList<>();
        dtos.forEach(dto -> entities.add(convertDtoToEntity(dto)));
        return entities;
    }

    private BrandDto convertEntityToDto(Brand entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, BrandDto.class);
    }

    private Brand convertDtoToEntity(BrandDto dto) {
        modelMapper.getConfiguration().setPreferNestedProperties(false);
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Brand.class);
    }

    private Brand withoutMaterials(Brand entity) {
        modelMapper.typeMap(Brand.class, Brand.class).addMappings(mapper -> mapper.skip(Brand::setMaterials));
        return modelMapper.map(entity, Brand.class);
    }
}
