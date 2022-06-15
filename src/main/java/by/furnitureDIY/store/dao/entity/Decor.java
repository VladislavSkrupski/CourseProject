package by.furnitureDIY.store.dao.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraph(name = "decor-graph",
        attributeNodes = {
                @NamedAttributeNode("decorArticle"),
                @NamedAttributeNode("decorName")
        }
)

@NamedEntityGraph(name = "decor-with-materials-graph",
        attributeNodes = {
                @NamedAttributeNode("decorArticle"),
                @NamedAttributeNode("decorName"),
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
@Table(name = "decors")
public class Decor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_decor", nullable = false)
    private Integer id;

    @Column(name = "decor_article")
    private String decorArticle;

    @Column(name = "decor_name")
    private String decorName;

    @OneToMany(mappedBy = "decor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Material> materials = new java.util.ArrayList<>();

    public Decor() {
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public String getDecorName() {
        return decorName;
    }

    public void setDecorName(String decorName) {
        this.decorName = decorName;
    }

    public String getDecorArticle() {
        return decorArticle;
    }

    public void setDecorArticle(String decorArticle) {
        this.decorArticle = decorArticle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}