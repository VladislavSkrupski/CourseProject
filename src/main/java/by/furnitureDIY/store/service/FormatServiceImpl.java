package by.furnitureDIY.store.service;

import by.furnitureDIY.store.dao.entity.Format;
import by.furnitureDIY.store.dao.repository.FormatOnlyRepository;
import by.furnitureDIY.store.dao.repository.FormatRepository;
import by.furnitureDIY.store.service.dto.FormatDto;
import by.furnitureDIY.store.service.interfaces.FormatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class FormatServiceImpl implements FormatService {
    private final FormatRepository formatRepository;
    private final FormatOnlyRepository formatOnlyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public FormatServiceImpl(FormatRepository formatRepository, FormatOnlyRepository formatOnlyRepository, ModelMapper modelMapper) {
        this.formatRepository = formatRepository;
        this.formatOnlyRepository = formatOnlyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public List<FormatDto> getAll() {
        List<Format> formats = formatRepository.findAll();
        return convertListEntitiesToListDtos(formats);
    }

    @Override
    @Transactional
    public List<FormatDto> getAllWithoutMaterials() {
        List<Format> formats = formatOnlyRepository.findAll();
        return convertListEntitiesToListDtosWithoutMaterials(formats);
    }

    @Override
    @Transactional
    public FormatDto findById(Integer id) {
        Format format = formatRepository.getById(id);
        return convertEntityToDto(format);
    }

    @Override
    @Transactional
    public FormatDto findByIdWithoutMaterials(Integer id) {
        Format format = formatOnlyRepository.getById(id);
        return convertEntityToDto(withoutMaterials(format));
    }

    @Override
    @Transactional
    public FormatDto deleteById(Integer id) {
        Format format;
        if (formatRepository.existsById(id)) {
            format = formatRepository.getById(id);
            formatRepository.deleteById(id);
        } else {
            format = null;
        }
        return convertEntityToDto(format);
    }

    @Override
    @Transactional
    public FormatDto create(FormatDto formatDto) {
        return convertEntityToDto(formatRepository.save(convertDtoToEntity(formatDto)));
    }

    @Override
    @Transactional
    public FormatDto update(FormatDto formatDto) {
        return convertEntityToDto(formatRepository.save(convertDtoToEntity(formatDto)));
    }

    //----------------------------------Convert methods-----------------------------------------

    private List<FormatDto> convertListEntitiesToListDtos(List<Format> entities) {
        List<FormatDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(convertEntityToDto(entity)));
        return dtos;
    }

    private List<FormatDto> convertListEntitiesToListDtosWithoutMaterials(List<Format> entities) {
        List<FormatDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(convertEntityToDto(withoutMaterials(entity))));
        return dtos;
    }

    private List<Format> convertListDtosToListEntities(List<FormatDto> dtos) {
        List<Format> entities = new ArrayList<>();
        dtos.forEach(dto -> entities.add(convertDtoToEntity(dto)));
        return entities;
    }

    private FormatDto convertEntityToDto(Format entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, FormatDto.class);
    }

    private Format convertDtoToEntity(FormatDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Format.class);
    }

    private Format withoutMaterials(Format entity) {
        modelMapper.typeMap(Format.class, Format.class).addMappings(mapper -> mapper.skip(Format::setMaterials));
        return modelMapper.map(entity, Format.class);
    }
}
