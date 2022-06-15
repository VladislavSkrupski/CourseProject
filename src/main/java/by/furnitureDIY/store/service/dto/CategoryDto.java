package by.furnitureDIY.store.service.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CategoryDto implements Serializable {
    private Integer id;
    private String category;
    private List<MaterialDto> materials;

    public CategoryDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public List<MaterialDto> getMaterials() {
        return materials;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setMaterials(List<MaterialDto> materials) {
        this.materials = materials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto entity = (CategoryDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.materials, entity.materials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, materials);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "category = " + category + ", " +
                "materials = " + materials + ")";
    }
}
