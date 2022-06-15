package by.furnitureDIY.store.dao.entity;

import javax.persistence.*;
import java.util.List;


@NamedEntityGraph(name = "brand-graph",
        attributeNodes = {
                @NamedAttributeNode("brand"),
        }
)

@NamedEntityGraph(name = "brand-with-materials-graph",
        attributeNodes = {
                @NamedAttributeNode("brand"),
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
@Table(name = "brands", indexes = {
        @Index(name = "brand_UNIQUE", columnList = "brand", unique = true)
})
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brand", nullable = false)
    private Integer id;

    @Column(name = "brand", unique = true)
    private String brand;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Material> materials = new java.util.ArrayList<>();

    public Brand() {
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}