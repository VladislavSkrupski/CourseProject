package by.furnitureDIY.store.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class MaterialDto implements Serializable {
    private Integer id;
    private BrandOnlyDto brand;
    private CategoryOnlyDto category;
    private FormatOnlyDto format;
    private ThicknessOnlyDto thickness;
    private DecorOnlyDto decor;
    private TextureOnlyDto texture;
    private String measureUnit;
    private BigDecimal cost;
    private String pictureAddress;

    public MaterialDto() {
    }

    public Integer getId() {
        return id;
    }

    public BrandOnlyDto getBrand() {
        return brand;
    }

    public CategoryOnlyDto getCategory() {
        return category;
    }

    public FormatOnlyDto getFormat() {
        return format;
    }

    public ThicknessOnlyDto getThickness() {
        return thickness;
    }

    public DecorOnlyDto getDecor() {
        return decor;
    }

    public TextureOnlyDto getTexture() {
        return texture;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getPictureAddress() {
        return pictureAddress;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrand(BrandOnlyDto brand) {
        this.brand = brand;
    }

    public void setCategory(CategoryOnlyDto category) {
        this.category = category;
    }

    public void setFormat(FormatOnlyDto format) {
        this.format = format;
    }

    public void setThickness(ThicknessOnlyDto thickness) {
        this.thickness = thickness;
    }

    public void setDecor(DecorOnlyDto decor) {
        this.decor = decor;
    }

    public void setTexture(TextureOnlyDto texture) {
        this.texture = texture;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setPictureAddress(String pictureAddress) {
        this.pictureAddress = pictureAddress;
    }

    public class BrandOnlyDto {
        private Integer id;
        private String brand;

        public BrandOnlyDto(Integer id, String brand) {
            this.id = id;
            this.brand = brand;
        }

        public Integer getId() {
            return id;
        }

        public String getBrand() {
            return brand;
        }

        @Override
        public String toString() {
            return "BrandOnlyDto{" + "id=" + id + ", brand='" + brand + '\'' + '}';
        }
    }

    public class CategoryOnlyDto {
        private Integer id;
        private String category;

        public CategoryOnlyDto() {
        }

        public CategoryOnlyDto(Integer id, String category) {
            this.id = id;
            this.category = category;
        }

        public Integer getId() {
            return id;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "CategoryOnlyDto{" +
                    "id=" + id +
                    ", category='" + category + '\'' +
                    '}';
        }
    }

    public class DecorOnlyDto {
        private Integer id;
        private String decorArticle;
        private String decorName;

        public DecorOnlyDto() {
        }

        public DecorOnlyDto(Integer id, String decorArticle, String decorName) {
            this.id = id;
            this.decorArticle = decorArticle;
            this.decorName = decorName;
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

        @Override
        public String toString() {
            return "DecorOnlyDto{" +
                    "id=" + id +
                    ", decorArticle='" + decorArticle + '\'' +
                    ", decorName='" + decorName + '\'' +
                    '}';
        }
    }

    public class FormatOnlyDto {
        private Integer id;
        private Integer length;
        private Integer width;

        public FormatOnlyDto() {
        }

        public FormatOnlyDto(Integer id, Integer length, Integer width) {
            this.id = id;
            this.length = length;
            this.width = width;
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

        @Override
        public String toString() {
            return "FormatOnlyDto{" +
                    "id=" + id +
                    ", length=" + length +
                    ", width=" + width +
                    '}';
        }
    }

    public class ThicknessOnlyDto {
        private Integer id;
        private BigDecimal thickness;

        public ThicknessOnlyDto() {
        }

        public ThicknessOnlyDto(Integer id, BigDecimal thickness) {
            this.id = id;
            this.thickness = thickness;
        }

        public Integer getId() {
            return id;
        }

        public BigDecimal getThickness() {
            return thickness;
        }

        @Override
        public String toString() {
            return "ThicknessOnlyDto{" +
                    "id=" + id +
                    ", thickness=" + thickness +
                    '}';
        }
    }

    public class TextureOnlyDto {
        private Integer id;
        private String texture;

        public TextureOnlyDto(Integer id, String texture) {
            this.id = id;
            this.texture = texture;
        }

        public Integer getId() {
            return id;
        }

        public String getTexture() {
            return texture;
        }

        @Override
        public String toString() {
            return "TextureOnlyDto{" +
                    "id=" + id +
                    ", texture='" + texture + '\'' +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialDto that = (MaterialDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(category, that.category) &&
                Objects.equals(format, that.format) &&
                Objects.equals(thickness, that.thickness) &&
                Objects.equals(decor, that.decor) &&
                Objects.equals(texture, that.texture) &&
                Objects.equals(measureUnit, that.measureUnit) &&
                Objects.equals(cost, that.cost) &&
                Objects.equals(pictureAddress, that.pictureAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, category, format, thickness, decor, texture, measureUnit, cost, pictureAddress);
    }

    @Override
    public String toString() {
        return "MaterialDto{" +
                "id=" + id +
                ", brand=" + brand +
                ", category=" + category +
                ", format=" + format +
                ", thickness=" + thickness +
                ", decor=" + decor +
                ", texture=" + texture +
                ", measureUnit='" + measureUnit + '\'' +
                ", cost=" + cost +
                ", pictureAddress='" + pictureAddress + '\'' +
                '}';
    }
}
