package DTOBuilder;

import Entityes.UserOrderEntity;

public class UserOrderBuilder {

    private Integer idorder;
    private Integer user;
    private Integer product;
    private Integer count;

    public UserOrderBuilder setIdorder(Integer idorder) {
        this.idorder = idorder;
        return this;
    }

    public UserOrderBuilder setUser(Integer user) {
        this.user = user;
        return this;
    }

    public UserOrderBuilder setProduct(Integer product) {
        this.product = product;
        return this;
    }

    public UserOrderBuilder setCount(Integer count) {
        this.count = count;
        return this;
    }

    public UserOrderEntity build() {
        return new UserOrderEntity(idorder, user, product, count);
    }
}
