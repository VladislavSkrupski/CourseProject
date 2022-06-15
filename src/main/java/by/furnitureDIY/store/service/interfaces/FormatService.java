package by.furnitureDIY.store.service.interfaces;

import by.furnitureDIY.store.service.dto.FormatDto;

import java.util.List;

public interface FormatService {
    List<FormatDto> getAll();

    List<FormatDto> getAllWithoutMaterials();

    FormatDto findById(Integer id);

    FormatDto findByIdWithoutMaterials(Integer id);

    FormatDto deleteById(Integer id);

    FormatDto create(FormatDto formatDto);

    FormatDto update(FormatDto formatDto);
}
