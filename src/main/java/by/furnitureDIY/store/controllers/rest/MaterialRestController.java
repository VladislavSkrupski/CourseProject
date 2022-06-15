package by.furnitureDIY.store.controllers.rest;

import by.furnitureDIY.store.service.dto.MaterialDto;
import by.furnitureDIY.store.service.interfaces.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("materials")
public class MaterialRestController {
    private final MaterialService materialService;

    @Autowired
    public MaterialRestController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping("")
    public List<MaterialDto> getMaterials() {
        return materialService.getAll();
    }

    @GetMapping("/{id}")
    public MaterialDto getMaterialById(@PathVariable(name = "id") int id) {
        return materialService.findById(id);
    }

    @PostMapping("")
    public MaterialDto postMaterial(@RequestBody MaterialDto materialDto) {
        return materialService.create(materialDto);
    }

    @DeleteMapping("/{id}")
    public MaterialDto deleteMaterial(@PathVariable(name = "id") int id) {
        return materialService.deleteById(id);
    }

}
