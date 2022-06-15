package by.furnitureDIY.store.dao.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NamedEntityGraph(name = "thickness-graph",
        attributeNodes = {
                @NamedAttributeNode("thickness")
        }
)

@NamedEntityGraph(name = "thickness-with-materials-graph",
        attributeNodes = {
                @NamedAttributeNode("thickness"),
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
@Table(name = "thickness", indexes = {
        @Index(name = "thickness_UNIQUE", columnList = "thickness", unique = true)
})
public class Thickness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_thickness", nullable = false)
    private Integer id;

    @Column(name = "thickness", nullable = false, precision = 10, scale = 1)
    private BigDecimal thickness;

    @OneToMany(mappedBy = "thickness", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Material> materials = new java.util.ArrayList<>();

    public Thickness() {
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public BigDecimal getThickness() {
        return thickness;
    }

    public void setThickness(BigDecimal thickness) {
        this.thickness = thickness;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}