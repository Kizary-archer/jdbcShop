package Entityes;

import java.util.Objects;

public class ProdtypeEntity {
    private Integer idtype;
    private String typename;

    public Integer getIdtype() {
        return idtype;
    }

    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdtypeEntity that = (ProdtypeEntity) o;
        return Objects.equals(idtype, that.idtype) &&
                Objects.equals(typename, that.typename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idtype, typename);
    }
}
