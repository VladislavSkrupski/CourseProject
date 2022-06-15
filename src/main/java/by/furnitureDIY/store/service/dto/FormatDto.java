package by.furnitureDIY.store.service.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class FormatDto implements Serializable {
    private Integer id;
    private Integer length;
    private Integer width;
    private List<MaterialDto> materials;

    public FormatDto() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getWidth() {
        return width;
    }

    public List<MaterialDto> getMaterials() {
        return materials;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setMaterials(List<MaterialDto> materials) {
        this.materials = materials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormatDto entity = (FormatDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.length, entity.length) &&
                Objects.equals(this.width, entity.width) &&
                Objects.equals(this.materials, entity.materials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, length, width, materials);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "length = " + length + ", " +
                "width = " + width + ", " +
                "materials = " + materials + ")";
    }
}
