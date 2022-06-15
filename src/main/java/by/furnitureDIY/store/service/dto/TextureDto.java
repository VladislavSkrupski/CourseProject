package by.furnitureDIY.store.service.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class TextureDto implements Serializable {
    private Integer id;
    private String texture;
    private List<MaterialDto> materials;

    public TextureDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getTexture() {
        return texture;
    }

    public List<MaterialDto> getMaterials() {
        return materials;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public void setMaterials(List<MaterialDto> materials) {
        this.materials = materials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextureDto entity = (TextureDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.texture, entity.texture) &&
                Objects.equals(this.materials, entity.materials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, texture, materials);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "texture = " + texture + ", " +
                "materials = " + materials + ")";
    }
}
