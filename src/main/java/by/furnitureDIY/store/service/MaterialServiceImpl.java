package by.furnitureDIY.store.service;

import by.furnitureDIY.store.dao.entity.Material;
import by.furnitureDIY.store.dao.repository.*;
import by.furnitureDIY.store.service.dto.MaterialDto;
import by.furnitureDIY.store.service.interfaces.MaterialService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;
    private final ModelMapper modelMapper;

    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final FormatRepository formatRepository;
    private final DecorRepository decorRepository;
    private final ThicknessRepository thicknessRepository;
    private final TextureRepository textureRepository;

    @Autowired
    public MaterialServiceImpl(MaterialRepository materialRepository,
                               ModelMapper modelMapper,
                               BrandRepository brandRepository,
                               CategoryRepository categoryRepository,
                               FormatRepository formatRepository,
                               DecorRepository decorRepository,
                               ThicknessRepository thicknessRepository,
                               TextureRepository textureRepository) {
        this.materialRepository = materialRepository;
        this.modelMapper = modelMapper;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
        this.formatRepository = formatRepository;
        this.decorRepository = decorRepository;
        this.thicknessRepository = thicknessRepository;
        this.textureRepository = textureRepository;
    }

    @Override
    @Transactional
    public List<MaterialDto> getAll() {
        List<Material> materials = materialRepository.findAll();
        return convertListEntitiesToListDtos(materials);
    }

    @Override
    @Transactional
    public MaterialDto findById(Integer id) {
        Material material = materialRepository.getById(id);
        return convertEntityToDto(material);
    }

    @Override
    @Transactional
    public MaterialDto deleteById(Integer id) {
        Material material;
        if (materialRepository.existsById(id)) {
            material = materialRepository.getById(id);
            materialRepository.deleteById(id);
        } else {
            material = null;
        }
        return convertEntityToDto(material);
    }

    @Override
    @Transactional
    public MaterialDto create(MaterialDto materialDto) {
        return convertEntityToDto(materialRepository.save(convertDtoToEntity(materialDto)));
    }

    @Override
    @Transactional
    public MaterialDto update(MaterialDto materialDto) {
        return convertEntityToDto(materialRepository.save(convertDtoToEntity(materialDto)));
    }

    //----------------------------------Convert methods-----------------------------------------
    private List<MaterialDto> convertListEntitiesToListDtos(List<Material> entities) {
        List<MaterialDto> dtos = new ArrayList<>();
        entities.forEach(entity -> dtos.add(convertEntityToDto(entity)));
        return dtos;
    }

    private List<Material> convertListDtosToListEntities(List<MaterialDto> dtos) {
        List<Material> entities = new ArrayList<>();
        dtos.forEach(dto -> entities.add(convertDtoToEntity(dto)));
        return entities;
    }

    private MaterialDto convertEntityToDto(Material entity) {
        modelMapper.getConfiguration().setPreferNestedProperties(false);
        return Objects.isNull(entity) ? null : modelMapper.map(entity, MaterialDto.class);
    }

    private Material convertDtoToEntity(MaterialDto dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Material.class);
    }

    @PostConstruct
    private void setupModelMapper() {
        modelMapper.createTypeMap(Material.class, MaterialDto.class)
                .addMappings(m -> {
                    m.skip(MaterialDto::setBrand);
                    m.skip(MaterialDto::setCategory);
                    m.skip(MaterialDto::setFormat);
                    m.skip(MaterialDto::setDecor);
                    m.skip(MaterialDto::setThickness);
                    m.skip(MaterialDto::setTexture);
                }).setPostConverter(toDto());
        modelMapper.createTypeMap(MaterialDto.class, Material.class)
                .addMappings(m -> {
                    m.skip(Material::setBrand);
                    m.skip(Material::setCategory);
                    m.skip(Material::setFormat);
                    m.skip(Material::setDecor);
                    m.skip(Material::setThickness);
                    m.skip(Material::setTexture);
                }).setPostConverter(toEntity());
    }

    private Converter<Material, MaterialDto> toDto() {
        return mappingContext -> {
            mapSkippedFields(mappingContext.getSource(), mappingContext.getDestination());
            return mappingContext.getDestination();
        };
    }

    private Converter<MaterialDto, Material> toEntity() {
        return mappingContext -> {
            mapSkippedFields(mappingContext.getSource(), mappingContext.getDestination());
            return mappingContext.getDestination();
        };
    }

    private void mapSkippedFields(Material source, MaterialDto destination) {
        if (Objects.isNull(source)) {
            destination.setBrand(null);
            destination.setCategory(null);
            destination.setDecor(null);
            destination.setFormat(null);
            destination.setThickness(null);
            destination.setTexture(null);
        } else {
            destination.setBrand(destination.new BrandOnlyDto(source.getBrand().getId(), source.getBrand().getBrand()));
            destination.setCategory(destination.new CategoryOnlyDto(source.getCategory().getId(), source.getCategory().getCategory()));
            destination.setDecor(destination.new DecorOnlyDto(source.getDecor().getId(), source.getDecor().getDecorArticle(), source.getDecor().getDecorName()));
            destination.setFormat(destination.new FormatOnlyDto(source.getFormat().getId(), source.getFormat().getLength(), source.getFormat().getWidth()));
            destination.setThickness(destination.new ThicknessOnlyDto(source.getThickness().getId(), source.getThickness().getThickness()));
            destination.setTexture(destination.new TextureOnlyDto(source.getTexture().getId(), source.getTexture().getTexture()));
        }
    }

    private void mapSkippedFields(MaterialDto source, Material destination) {
        destination.setBrand(brandRepository.findById(source.getBrand().getId()).orElse(null));
        destination.setCategory(categoryRepository.findById(source.getCategory().getId()).orElse(null));
        destination.setFormat(formatRepository.findById(source.getFormat().getId()).orElse(null));
        destination.setDecor(decorRepository.findById(source.getDecor().getId()).orElse(null));
        destination.setThickness(thicknessRepository.findById(source.getThickness().getId()).orElse(null));
        destination.setTexture(textureRepository.findById(source.getTexture().getId()).orElse(null));
    }
}

