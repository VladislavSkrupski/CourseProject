package by.furnitureDIY.store.service;

import by.furnitureDIY.store.dao.entity.Texture;
import by.furnitureDIY.store.dao.repository.TextureOnlyRepository;
import by.furnitureDIY.store.dao.repository.TextureRepository;
import by.furnitureDIY.store.service.dto.TextureDto;
import by.furnitureDIY.store.service.interfaces.TextureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TextureServiceImpl implements TextureService {
    private final TextureRepository textureRepository;
    private final TextureOnlyRepository textureOnlyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TextureServiceImpl(TextureRepository textureRepository, TextureOnlyRepository textureOnlyRepository, ModelMapper modelMapper) {
        this.textureRepository = textureRepository;
        this.textureOnlyRepository = textureOnlyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<TextureDto> getAll() {
        List<Texture> textures = textureRepository.findAll();
        return convertListEntitiesToListDtos(textures);
    }

    @Override
    @Transactional
    public List<TextureDto> getAllWithoutMaterials() {
        List<Texture> textures = textureOnlyRepository.findAll();
        return convertListEntitiesToListDtosWithoutMaterials(textures);
    }

    @Override
    @Transactional
    public TextureDto findById(Integer id) {
        Texture texture = textureRepository.getById(id);
        return convertEntityToDto(texture);
    }

    @Override
    @Transactional
    public TextureDto findByIdWithoutMaterials(Integer id) {
        Texture texture = textureOnlyRepository.getById(id);
        return convertEntityToDto(withoutMaterials(texture));
    }

    @Override
    @Transactional
    public TextureDto deleteById(Integer id) {
        Texture texture;
        if (textureRepository.existsById(id)) {
            texture = textureRepository.getById(id);
            textureRepository.deleteById(id);
        } else {
            texture = null;
        }
        return convertEntityToDto(texture);
    }

    @Override
    @Transactional
    public TextureDto create(TextureDto textureDto) {
        return convertEntityToDto(textureRepository.save(convertDtoToEntity(textureDto)));
    }

    @Override
    @Transactional
    public TextureDto update(TextureDto textureDto) {
        return convertEntityToDto(textureRepository.save(convertDtoToEntity(textureDto)));
    }

    //----------------------------------Convert methods-----------------------------------------

    private List<TextureDto> convertListEntitiesToListDtos(List<Texture> entities) {
        List<TextureDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(convertEntityToDto(entity)));
        return dtos;
    }

    private List<TextureDto> convertListEntitiesToListDtosWithoutMaterials(List<Texture> entities) {
        List<TextureDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(convertEntityToDto(withoutMaterials(entity))));
        return dtos;
    }

    private List<Texture> convertListDtosToListEntities(List<TextureDto> dtos) {
        List<Texture> entities = new ArrayList<>();
        dtos.forEach(dto -> entities.add(convertDtoToEntity(dto)));
        return entities;
    }

    private TextureDto convertEntityToDto(Texture entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, TextureDto.class);
    }

    private Texture convertDtoToEntity(TextureDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Texture.class);
    }

    private Texture withoutMaterials(Texture entity) {
        modelMapper.typeMap(Texture.class, Texture.class).addMappings(mapper -> mapper.skip(Texture::setMaterials));
        return modelMapper.map(entity, Texture.class);
    }
}

