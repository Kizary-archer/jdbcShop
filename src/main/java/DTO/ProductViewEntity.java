package DTO;

import java.util.Objects;

public class ProductViewEntity {
    private Integer idproduct;
    private String nameprod;
    private String typename;
    private String namemanuf;
    private Long price;

    public ProductViewEntity(Integer idproduct, String nameprod, String typename, String namemanuf, Long price) {
        this.idproduct = idproduct;
        this.nameprod = nameprod;
        this.typename = typename;
        this.namemanuf = namemanuf;
        this.price = price;
    }

    public Integer getIdproduct() {
        return idproduct;
    }

    public String getNameprod() {
        return nameprod;
    }

    public String getTypename() {
        return typename;
    }

    public String getNamemanuf() {
        return namemanuf;
    }

    public Long getPrice() {
        return price;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
    }

    public void setNameprod(String nameprod) {
        this.nameprod = nameprod;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public void setNamemanuf(String namemanuf) {
        this.namemanuf = namemanuf;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductViewEntity that = (ProductViewEntity) o;
        return Objects.equals(idproduct, that.idproduct) &&
                Objects.equals(nameprod, that.nameprod) &&
                Objects.equals(typename, that.typename) &&
                Objects.equals(namemanuf, that.namemanuf) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproduct, nameprod, typename, namemanuf, price);
    }
}
