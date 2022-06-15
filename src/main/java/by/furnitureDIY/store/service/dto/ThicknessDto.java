package by.furnitureDIY.store.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ThicknessDto implements Serializable {
    private Integer id;
    private BigDecimal thickness;
    private List<MaterialDto> materials;

    public ThicknessDto() {
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getThickness() {
        return thickness;
    }

    public List<MaterialDto> getMaterials() {
        return materials;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setThickness(BigDecimal thickness) {
        this.thickness = thickness;
    }

    public void setMaterials(List<MaterialDto> materials) {
        this.materials = materials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThicknessDto entity = (ThicknessDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.thickness, entity.thickness) &&
                Objects.equals(this.materials, entity.materials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, thickness, materials);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "thickness = " + thickness + ", " +
                "materials = " + materials + ")";
    }
}
