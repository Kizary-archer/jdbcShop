package DTO;

import java.util.Objects;

public class UserOrderEntity {

    private Integer idorder;
    private Integer user;
    private Integer product;
    private Integer count;

    public UserOrderEntity(){}
    public UserOrderEntity(Integer idorder, Integer user, Integer product, Integer count) {
        this.idorder = idorder;
        this.user = user;
        this.product = product;
        this.count = count;
    }

    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOrderEntity that = (UserOrderEntity) o;
        return Objects.equals(idorder, that.idorder) &&
                Objects.equals(user, that.user) &&
                Objects.equals(product, that.product) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idorder, user, product, count);
    }
}
