package by.furnitureDIY.store.dao.entity;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraph(name = "category-graph",
        attributeNodes = {
                @NamedAttributeNode("category")
        }
)

@NamedEntityGraph(name = "category-with-materials-graph",
        attributeNodes = {
                @NamedAttributeNode("category"),
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
@Table(name = "categories", indexes = {
        @Index(name = "Category_UNIQUE", columnList = "Category", unique = true)
})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category", nullable = false)
    private Integer id;

    @Column(name = "Category", nullable = false)
    private String category;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Material> materials = new java.util.ArrayList<>();

    public Category() {
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}