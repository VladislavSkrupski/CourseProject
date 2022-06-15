package by.furnitureDIY.store.dao.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraph(name = "format-graph",
        attributeNodes = {
                @NamedAttributeNode("length"),
                @NamedAttributeNode("width")
        }
)

@NamedEntityGraph(name = "format-with-materials-graph",
        attributeNodes = {
                @NamedAttributeNode("length"),
                @NamedAttributeNode("width"),
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
@Table(name = "formats")
public class Format {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_format", nullable = false)
    private Integer id;

    @Column(name = "length", nullable = false)
    private Integer length;

    @Column(name = "width", nullable = false)
    private Integer width;

    @OneToMany(mappedBy = "format", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Material> materials = new java.util.ArrayList<>();

    public Format() {
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}