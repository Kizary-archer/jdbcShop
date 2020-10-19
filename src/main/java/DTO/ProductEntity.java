package DTO;

import java.util.Objects;

public class ProductEntity {
    private Integer idproduct;
    private String nameprod;
    private Integer manufacture;
    private Integer type;
    private Long price;

    public ProductEntity(Integer idproduct, String nameprod, Integer manufacture, Integer type, Long price) {
        this.idproduct = idproduct;
        this.nameprod = nameprod;
        this.manufacture = manufacture;
        this.type = type;
        this.price = price;
    }

    public ProductEntity(){}

    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    public String getNameprod() {
        return nameprod;
    }

    public void setNameprod(String nameprod) {
        this.nameprod = nameprod;
    }

    public Integer getManufacture() {
        return manufacture;
    }

    public void setManufacture(Integer manufacture) {
        this.manufacture = manufacture;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(idproduct, that.idproduct) &&
                Objects.equals(nameprod, that.nameprod) &&
                Objects.equals(manufacture, that.manufacture) &&
                Objects.equals(type, that.type) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproduct, nameprod, manufacture, type, price);
    }
}
