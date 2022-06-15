package by.furnitureDIY.store.service.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class DecorDto implements Serializable {
    private Integer id;
    private String decorArticle;
    private String decorName;
    private List<MaterialDto> materials;

    public DecorDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getDecorArticle() {
        return decorArticle;
    }

    public String getDecorName() {
        return decorName;
    }

    public List<MaterialDto> getMaterials() {
        return materials;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDecorArticle(String decorArticle) {
        this.decorArticle = decorArticle;
    }

    public void setDecorName(String decorName) {
        this.decorName = decorName;
    }

    public void setMaterials(List<MaterialDto> materials) {
        this.materials = materials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DecorDto entity = (DecorDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.decorArticle, entity.decorArticle) &&
                Objects.equals(this.decorName, entity.decorName) &&
                Objects.equals(this.materials, entity.materials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, decorArticle, decorName, materials);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "decorArticle = " + decorArticle + ", " +
                "decorName = " + decorName + ", " +
                "materials = " + materials + ")";
    }
}
