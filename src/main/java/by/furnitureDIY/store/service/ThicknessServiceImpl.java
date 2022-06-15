package by.furnitureDIY.store.service;

import by.furnitureDIY.store.dao.entity.Thickness;
import by.furnitureDIY.store.dao.repository.ThicknessOnlyRepository;
import by.furnitureDIY.store.dao.repository.ThicknessRepository;
import by.furnitureDIY.store.service.dto.ThicknessDto;
import by.furnitureDIY.store.service.interfaces.ThicknessService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ThicknessServiceImpl implements ThicknessService {
    private final ThicknessRepository thicknessRepository;
    private final ThicknessOnlyRepository thicknessOnlyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ThicknessServiceImpl(ThicknessRepository thicknessRepository, ThicknessOnlyRepository thicknessOnlyRepository, ModelMapper modelMapper) {
        this.thicknessRepository = thicknessRepository;
        this.thicknessOnlyRepository = thicknessOnlyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<ThicknessDto> getAll() {
        List<Thickness> thicknesses = thicknessRepository.findAll();
        return convertListEntitiesToListDtos(thicknesses);
    }

    @Override
    @Transactional
    public List<ThicknessDto> getAllWithoutMaterials() {
        List<Thickness> thicknesses = thicknessOnlyRepository.findAll();
        return convertListEntitiesToListDtosWithoutMaterials(thicknesses);
    }

    @Override
    @Transactional
    public ThicknessDto findById(Integer id) {
        Thickness thickness = thicknessRepository.getById(id);
        return convertEntityToDto(thickness);
    }

    @Override
    @Transactional
    public ThicknessDto findByIdWithoutMaterials(Integer id) {
        Thickness thickness = thicknessOnlyRepository.getById(id);
        return convertEntityToDto(withoutMaterials(thickness));
    }

    @Override
    @Transactional
    public ThicknessDto deleteById(Integer id) {
        Thickness thickness;
        if (thicknessRepository.existsById(id)) {
            thickness = thicknessRepository.getById(id);
            thicknessRepository.deleteById(id);
        } else {
            thickness = null;
        }
        return convertEntityToDto(thickness);
    }

    @Override
    @Transactional
    public ThicknessDto create(ThicknessDto thicknessDto) {
        return convertEntityToDto(thicknessRepository.save(convertDtoToEntity(thicknessDto)));
    }

    @Override
    @Transactional
    public ThicknessDto update(ThicknessDto thicknessDto) {
        return convertEntityToDto(thicknessRepository.save(convertDtoToEntity(thicknessDto)));
    }

    //----------------------------------Convert methods-----------------------------------------

    private List<ThicknessDto> convertListEntitiesToListDtos(List<Thickness> entities) {
        List<ThicknessDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(convertEntityToDto(entity)));
        return dtos;
    }

    private List<ThicknessDto> convertListEntitiesToListDtosWithoutMaterials(List<Thickness> entities) {
        List<ThicknessDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(convertEntityToDto(withoutMaterials(entity))));
        return dtos;
    }

    private List<Thickness> convertListDtosToListEntities(List<ThicknessDto> dtos) {
        List<Thickness> entities = new ArrayList<>();
        dtos.forEach(dto -> entities.add(convertDtoToEntity(dto)));
        return entities;
    }

    private ThicknessDto convertEntityToDto(Thickness entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, ThicknessDto.class);
    }

    private Thickness convertDtoToEntity(ThicknessDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Thickness.class);
    }

    private Thickness withoutMaterials(Thickness entity) {
        modelMapper.typeMap(Thickness.class, Thickness.class).addMappings(mapper -> mapper.skip(Thickness::setMaterials));
        return modelMapper.map(entity, Thickness.class);
    }
}
