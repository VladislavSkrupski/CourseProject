package by.furnitureDIY.store.controllers.rest;

import by.furnitureDIY.store.service.dto.DecorDto;
import by.furnitureDIY.store.service.interfaces.DecorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("decors")
public class DecorRestController {
    private final DecorService decorService;

    @Autowired
    public DecorRestController(DecorService decorService) {
        this.decorService = decorService;
    }

    @GetMapping("")
    public List<DecorDto> getDecors() {
        return decorService.getAll();
    }

    @GetMapping("/{id}")
    public DecorDto getDecorById(@PathVariable(name = "id") int id) {
        return decorService.findById(id);
    }

    @GetMapping("/only")
    public List<DecorDto> getDecorsOnly() {
        return decorService.getAllWithoutMaterials();
    }

    @GetMapping("/only/{id}")
    public DecorDto getDecorByIdOnly(@PathVariable(name = "id") int id) {
        return decorService.findByIdWithoutMaterials(id);
    }

    @PostMapping("")
    public DecorDto postDecor(@RequestBody DecorDto decorDto) {
        return decorService.create(decorDto);
    }

    @DeleteMapping("/{id}")
    public DecorDto deleteDecorById(@PathVariable(name = "id") int id) {
        return decorService.deleteById(id);
    }

}
