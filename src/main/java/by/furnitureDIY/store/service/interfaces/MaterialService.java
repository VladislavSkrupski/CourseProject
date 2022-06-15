package by.furnitureDIY.store.service.interfaces;

import by.furnitureDIY.store.service.dto.MaterialDto;

import java.util.List;

public interface MaterialService {
    List<MaterialDto> getAll();

    MaterialDto findById(Integer id);

    MaterialDto deleteById(Integer id);

    MaterialDto create(MaterialDto materialDto);

    MaterialDto update(MaterialDto materialDto);
}
