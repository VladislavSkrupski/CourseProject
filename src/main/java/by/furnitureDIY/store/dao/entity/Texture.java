package by.furnitureDIY.store.dao.entity;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraph(name = "texture-graph",
        attributeNodes = {
                @NamedAttributeNode("texture")
        }
)

@NamedEntityGraph(name = "texture-with-materials-graph",
        attributeNodes = {
                @NamedAttributeNode("texture"),
                @NamedAttributeNode(value = "materials", subgraph = "materials-subgraph"),},
        subgraphs = {
                @NamedSubgraph(
                        name = "materials-subgraph",
                        attributeNodes = {
                                @NamedAttributeNode("brand"),
                                @NamedAttributeNode("category"),
                                @NamedAttributeNode("decor"),
                                @NamedAttributeNode("format"),
                                @NamedAttributeNode("thickness"),
                                @NamedAttributeNode("texture")
                        }
                )
        }
)

@Entity
@Table(name = "textures")
public class Texture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_texture", nullable = false)
    private Integer id;

    @Column(name = "Texture")
    private String texture;

    @OneToMany(mappedBy = "texture", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Material> materials = new java.util.ArrayList<>();

    public Texture() {
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}