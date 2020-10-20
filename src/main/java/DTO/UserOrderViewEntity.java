package DTO;

import java.util.Objects;

public class UserOrderViewEntity {
    private String nameprod;
    private String typename;
    private String namemanuf;
    private Long price;
    private Integer count;
    private Long finalprice;

    public UserOrderViewEntity() {
    }

    public UserOrderViewEntity(String nameprod, String typename, String namemanuf, Long price, Integer count, Long finalprice) {
        this.nameprod = nameprod;
        this.typename = typename;
        this.namemanuf = namemanuf;
        this.price = price;
        this.count = count;
        this.finalprice = finalprice;
    }

    public String getNameprod() {
        return nameprod;
    }

    public void setNameprod(String nameprod) {
        this.nameprod = nameprod;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getNamemanuf() {
        return namemanuf;
    }

    public void setNamemanuf(String namemanuf) {
        this.namemanuf = namemanuf;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getFinalprice() {
        return finalprice;
    }

    public void setFinalprice(Long finalprice) {
        this.finalprice = finalprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserOrderViewEntity that = (UserOrderViewEntity) o;
        return Objects.equals(nameprod, that.nameprod) &&
                Objects.equals(typename, that.typename) &&
                Objects.equals(namemanuf, that.namemanuf) &&
                Objects.equals(price, that.price) &&
                Objects.equals(count, that.count) &&
                Objects.equals(finalprice, that.finalprice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameprod, typename, namemanuf, price, count, finalprice);
    }
}
