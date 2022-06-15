package by.furnitureDIY.store.service.interfaces;

import by.furnitureDIY.store.service.dto.DecorDto;

import java.util.List;

public interface DecorService {
    List<DecorDto> getAll();

    List<DecorDto> getAllWithoutMaterials();

    DecorDto findById(Integer id);

    DecorDto findByIdWithoutMaterials(Integer id);

    DecorDto deleteById(Integer id);

    DecorDto create(DecorDto decorDto);

    DecorDto update(DecorDto decorDto);
}
