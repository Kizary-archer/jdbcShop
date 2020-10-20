package DTOBuilder;

import DTO.UserOrderViewEntity;

public class UserOrderViewBuilder {
    private String nameprod;
    private String typename;
    private String namemanuf;
    private Long price;
    private Integer count;
    private Long finalprice;

    public UserOrderViewBuilder setNameprod(String nameprod) {
        this.nameprod = nameprod;
        return this;
    }

    public UserOrderViewBuilder setTypename(String typename) {
        this.typename = typename;
        return this;
    }

    public UserOrderViewBuilder setNamemanuf(String namemanuf) {
        this.namemanuf = namemanuf;
        return this;
    }

    public UserOrderViewBuilder setPrice(Long price) {
        this.price = price;
        return this;
    }

    public UserOrderViewBuilder setCount(Integer count) {
        this.count = count;
        return this;
    }

    public UserOrderViewBuilder setFinalprice(Long finalprice) {
        this.finalprice = finalprice;
        return this;
    }
    public UserOrderViewEntity build(){
        return new UserOrderViewEntity(nameprod,typename,namemanuf,price,count,finalprice);
    }
}
