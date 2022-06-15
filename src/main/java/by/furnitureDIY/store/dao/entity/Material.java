package by.furnitureDIY.store.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "materials", indexes = {
        @Index(name = "fk_Materials_Categories1_idx", columnList = "f_id_category"),
        @Index(name = "fk_Materials_Format1_idx", columnList = "f_id_format"),
        @Index(name = "fk_Materials_decors1_idx", columnList = "f_id_decor"),
        @Index(name = "fk_Materials_Textures1_idx", columnList = "f_id_texture"),
        @Index(name = "fk_Materials_Thickness1_idx", columnList = "f_id_thickness"),
        @Index(name = "fk_material_brand_idx", columnList = "f_id_brand")
})

public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_materials", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_id_brand", nullable = false)
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_id_category", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_id_format", nullable = false)
    private Format format;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_id_thickness", nullable = false)
    private Thickness thickness;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_id_decor", nullable = false)
    private Decor decor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_id_texture", nullable = false)
    private Texture texture;

    @Column(name = "measure_unit")
    private String measureUnit;

    @Column(name = "cost", precision = 10, scale = 4)
    private BigDecimal cost;

    @Column(name = "picture_address")
    private String pictureAddress;

    public Material() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Thickness getThickness() {
        return thickness;
    }

    public void setThickness(Thickness thickness) {
        this.thickness = thickness;
    }

    public Decor getDecor() {
        return decor;
    }

    public void setDecor(Decor decor) {
        this.decor = decor;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }
}