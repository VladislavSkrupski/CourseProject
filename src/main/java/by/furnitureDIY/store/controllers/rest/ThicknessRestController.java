package by.furnitureDIY.store.controllers.rest;

import by.furnitureDIY.store.service.dto.ThicknessDto;
import by.furnitureDIY.store.service.interfaces.ThicknessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("thicknesses")
public class ThicknessRestController {
    private final ThicknessService thicknessService;

    @Autowired
    public ThicknessRestController(ThicknessService thicknessService) {
        this.thicknessService = thicknessService;
    }

    @GetMapping("")
    public List<ThicknessDto> getThicknesses() {
        return thicknessService.getAll();
    }

    @GetMapping("/{id}")
    public ThicknessDto getThicknessById(@PathVariable(name = "id") int id) {
        return thicknessService.findById(id);
    }

    @GetMapping("/only")
    public List<ThicknessDto> getThicknessesOnly() {
        return thicknessService.getAllWithoutMaterials();
    }

    @GetMapping("/only/{id}")
    public ThicknessDto getThicknessByIdOnly(@PathVariable(name = "id") int id) {
        return thicknessService.findByIdWithoutMaterials(id);
    }

    @PostMapping("")
    public ThicknessDto postThickness(@RequestBody ThicknessDto thicknessDto) {
        return thicknessService.create(thicknessDto);
    }

    @DeleteMapping("/{id}")
    public ThicknessDto deleteThicknessById(@PathVariable(name = "id") int id) {
        return thicknessService.deleteById(id);
    }
}
