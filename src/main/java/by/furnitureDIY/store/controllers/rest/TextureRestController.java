package by.furnitureDIY.store.controllers.rest;

import by.furnitureDIY.store.service.dto.TextureDto;
import by.furnitureDIY.store.service.interfaces.TextureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("textures")
public class TextureRestController {
    private final TextureService textureService;

    @Autowired
    public TextureRestController(TextureService textureService) {
        this.textureService = textureService;
    }

    @GetMapping("")
    public List<TextureDto> getTextures() {
        return textureService.getAll();
    }

    @GetMapping("/{id}")
    public TextureDto getTextureById(@PathVariable(name = "id") int id) {
        return textureService.findById(id);
    }

    @GetMapping("/only")
    public List<TextureDto> getTexturesOnly() {
        return textureService.getAllWithoutMaterials();
    }

    @GetMapping("/only/{id}")
    public TextureDto getTextureByIdOnly(@PathVariable(name = "id") int id) {
        return textureService.findByIdWithoutMaterials(id);
    }

    @PostMapping("")
    public TextureDto postTexture(@RequestBody TextureDto textureDto) {
        return textureService.create(textureDto);
    }

    @DeleteMapping("/{id}")
    public TextureDto deleteTexturById(@PathVariable(name = "id") int id) {
        return textureService.deleteById(id);
    }
}
