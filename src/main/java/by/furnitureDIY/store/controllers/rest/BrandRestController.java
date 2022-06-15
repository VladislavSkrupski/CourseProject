package by.furnitureDIY.store.controllers.rest;

import by.furnitureDIY.store.service.dto.BrandDto;
import by.furnitureDIY.store.service.interfaces.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("brands")
public class BrandRestController {
    private final BrandService brandService;

    @Autowired
    public BrandRestController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("")
    public List<BrandDto> getBrands() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public BrandDto getBrandById(@PathVariable(name = "id") int id) {
        return brandService.findById(id);
    }

    @GetMapping("/only")
    public List<BrandDto> getBrandsOnly() {
        return brandService.getAllWithoutMaterials();
    }

    @GetMapping("/only/{id}")
    public BrandDto getBrandByIdOnly(@PathVariable(name = "id") int id) {
        return brandService.findByIdWithoutMaterials(id);
    }

    @GetMapping("/param/{brandName}")
    public BrandDto getBrandByBrand(@PathVariable(name = "brandName") String brandName) {
        return brandService.findByBrand(brandName);
    }

    @GetMapping("/only/param/{brandName}")
    public BrandDto getBrandByBrandOnly(@PathVariable(name = "brandName") String brandName) {
        return brandService.findByBrandWithoutMaterials(brandName);
    }

    @PostMapping("")
    public BrandDto postBrand(@RequestBody BrandDto brandDto) {
        return brandService.create(brandDto);
    }

    @DeleteMapping("/{id}")
    public BrandDto deleteBrandById(@PathVariable(name = "id") int id) {
        return brandService.deleteById(id);
    }

    @PutMapping("")
    public BrandDto putBrand(@RequestBody BrandDto brandDto) {
        return brandService.update(brandDto);
    }
}


