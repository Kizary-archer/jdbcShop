package DTOBuilder;

import DTO.ProductEntity;

public class ProductBuilder {

    private Integer idproduct;
    private String nameprod;
    private Integer manufacture;
    private Integer type;
    private Long price;


    public ProductBuilder setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
        return this;
    }

    public ProductBuilder setNameprod(String nameprod) {
        this.nameprod = nameprod;
        return this;
    }

    public ProductBuilder setManufacture(Integer manufacture) {
        this.manufacture = manufacture;
        return this;
    }

    public ProductBuilder setType(Integer type) {
        this.type = type;
        return this;
    }

    public ProductBuilder setPrice(Long price) {
        this.price = price;
        return this;
    }

    public ProductEntity build() {
        return new ProductEntity(idproduct, nameprod, manufacture, type, price);
    }
}
