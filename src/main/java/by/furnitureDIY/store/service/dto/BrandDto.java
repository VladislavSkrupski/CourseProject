package by.furnitureDIY.store.service.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class BrandDto implements Serializable {
    private Integer id;
    private String brand;
    private List<MaterialDto> materials;

    public BrandDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public List<MaterialDto> getMaterials() {
        return materials;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMaterials(List<MaterialDto> materials) {
        this.materials = materials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrandDto entity = (BrandDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.brand, entity.brand) &&
                Objects.equals(this.materials, entity.materials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, materials);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "brand = " + brand + ", " +
                "materials = " + materials + ")";
    }
}
