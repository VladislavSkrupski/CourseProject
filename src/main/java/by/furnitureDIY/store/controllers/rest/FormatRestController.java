package by.furnitureDIY.store.controllers.rest;

import by.furnitureDIY.store.service.dto.FormatDto;
import by.furnitureDIY.store.service.interfaces.FormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("formats")
public class FormatRestController {
    private final FormatService formatService;

    @Autowired
    public FormatRestController(FormatService formatService) {
        this.formatService = formatService;
    }

    @GetMapping("")
    public List<FormatDto> getFormats() {
        return formatService.getAll();
    }

    @GetMapping("/{id}")
    public FormatDto getFormatById(@PathVariable(name = "id") int id) {
        return formatService.findById(id);
    }

    @GetMapping("/only")
    public List<FormatDto> getFormatsOnly() {
        return formatService.getAllWithoutMaterials();
    }

    @GetMapping("/only/{id}")
    public FormatDto getFormatByIdOnly(@PathVariable(name = "id") int id) {
        return formatService.findByIdWithoutMaterials(id);
    }

    @PostMapping("")
    public FormatDto postFormat(@RequestBody FormatDto formatDto) {
        return formatService.create(formatDto);
    }

    @DeleteMapping("/{id}")
    public FormatDto deleteFormatById(@PathVariable(name = "id") int id) {
        return formatService.deleteById(id);
    }

}
