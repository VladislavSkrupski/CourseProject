package by.furnitureDIY.store.service.interfaces;

import by.furnitureDIY.store.service.dto.ThicknessDto;

import java.util.List;

public interface ThicknessService {
    List<ThicknessDto> getAll();

    List<ThicknessDto> getAllWithoutMaterials();

    ThicknessDto findById(Integer id);

    ThicknessDto findByIdWithoutMaterials(Integer id);

    ThicknessDto deleteById(Integer id);

    ThicknessDto create(ThicknessDto thicknessDto);

    ThicknessDto update(ThicknessDto thicknessDto);
}
