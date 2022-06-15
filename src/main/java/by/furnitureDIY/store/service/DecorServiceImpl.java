package by.furnitureDIY.store.service;

import by.furnitureDIY.store.dao.entity.Decor;
import by.furnitureDIY.store.dao.repository.DecorOnlyRepository;
import by.furnitureDIY.store.dao.repository.DecorRepository;
import by.furnitureDIY.store.service.dto.DecorDto;
import by.furnitureDIY.store.service.interfaces.DecorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class DecorServiceImpl implements DecorService {
    private final DecorRepository decorRepository;
    private final DecorOnlyRepository decorOnlyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DecorServiceImpl(DecorRepository decorRepository, DecorOnlyRepository decorOnlyRepository, ModelMapper modelMapper) {
        this.decorRepository = decorRepository;
        this.decorOnlyRepository = decorOnlyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<DecorDto> getAll() {
        List<Decor> decors = decorRepository.findAll();
        return convertListEntitiesToListDtos(decors);
    }

    @Override
    @Transactional
    public List<DecorDto> getAllWithoutMaterials() {
        List<Decor> decors = decorOnlyRepository.findAll();
        return convertListEntitiesToListDtosWithoutMaterials(decors);
    }

    @Override
    @Transactional
    public DecorDto findById(Integer id) {
        Decor decor = decorRepository.getById(id);
        return convertEntityToDto(decor);
    }

    @Override
    @Transactional
    public DecorDto findByIdWithoutMaterials(Integer id) {
        Decor decor = decorOnlyRepository.getById(id);
        return convertEntityToDto(withoutMaterials(decor));
    }

    @Override
    @Transactional
    public DecorDto deleteById(Integer id) {
        Decor decor;
        if (decorRepository.existsById(id)) {
            decor = decorRepository.getById(id);
            decorRepository.deleteById(id);
        } else {
            decor = null;
        }
        return convertEntityToDto(decor);
    }

    @Override
    @Transactional
    public DecorDto create(DecorDto decorDto) {
        return convertEntityToDto(decorRepository.save(convertDtoToEntity(decorDto)));
    }

    @Override
    @Transactional
    public DecorDto update(DecorDto decorDto) {
        return convertEntityToDto(decorRepository.save(convertDtoToEntity(decorDto)));
    }

    //----------------------------------Convert methods-----------------------------------------

    private List<DecorDto> convertListEntitiesToListDtos(List<Decor> entities) {
        List<DecorDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(convertEntityToDto(entity)));
        return dtos;
    }

    private List<DecorDto> convertListEntitiesToListDtosWithoutMaterials(List<Decor> entities) {
        List<DecorDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(convertEntityToDto(withoutMaterials(entity))));
        return dtos;
    }

    private List<Decor> convertListDtosToListEntities(List<DecorDto> dtos) {
        List<Decor> entities = new ArrayList<>();
        dtos.forEach(dto -> entities.add(convertDtoToEntity(dto)));
        return entities;
    }

    private DecorDto convertEntityToDto(Decor entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, DecorDto.class);
    }

    private Decor convertDtoToEntity(DecorDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Decor.class);
    }

    private Decor withoutMaterials(Decor entity) {
        modelMapper.typeMap(Decor.class, Decor.class).addMappings(mapper -> mapper.skip(Decor::setMaterials));
        return modelMapper.map(entity, Decor.class);
    }
}
