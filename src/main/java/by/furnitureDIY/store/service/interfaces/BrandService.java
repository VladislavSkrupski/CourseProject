package by.furnitureDIY.store.service.interfaces;

import by.furnitureDIY.store.service.dto.BrandDto;

import java.util.List;

public interface BrandService {
    List<BrandDto> getAll();

    List<BrandDto> getAllWithoutMaterials();

    BrandDto findById(Integer id);

    BrandDto findByBrand(String brandName);

    BrandDto findByBrandWithoutMaterials(String brandName);

    BrandDto findByIdWithoutMaterials(Integer id);

    BrandDto deleteById(Integer id);

    BrandDto create(BrandDto brandDto);

    BrandDto update(BrandDto brandDto);
}
