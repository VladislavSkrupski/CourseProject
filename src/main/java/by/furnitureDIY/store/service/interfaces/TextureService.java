package by.furnitureDIY.store.service.interfaces;

import by.furnitureDIY.store.service.dto.TextureDto;

import java.util.List;

public interface TextureService {
    List<TextureDto> getAll();

    List<TextureDto> getAllWithoutMaterials();

    TextureDto findById(Integer id);

    TextureDto findByIdWithoutMaterials(Integer id);

    TextureDto deleteById(Integer id);

    TextureDto create(TextureDto textureDto);

    TextureDto update(TextureDto textureDto);
}
