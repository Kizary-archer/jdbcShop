package DTOBuilder;

import DTO.ProductViewEntity;

public class ProductViewBuilder {
    private Integer idproduct;
    private String nameprod;
    private String typename;
    private String namemanuf;
    private Long price;

    public ProductViewBuilder setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
        return this;
    }

    public ProductViewBuilder setNameprod(String nameprod) {
        this.nameprod = nameprod;
        return this;
    }

    public ProductViewBuilder setTypename(String typename) {
        this.typename = typename;
        return this;
    }

    public ProductViewBuilder setNamemanuf(String namemanuf) {
        this.namemanuf = namemanuf;
        return this;
    }

    public ProductViewBuilder setPrice(Long price) {
        this.price = price;
        return this;
    }
    public ProductViewEntity build(){
        return new ProductViewEntity(idproduct,nameprod,typename,namemanuf,price);
    }
}
