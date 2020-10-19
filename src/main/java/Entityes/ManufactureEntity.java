package Entityes;

import java.util.Objects;

public class ManufactureEntity {
    private Integer idmanuf;
    private String namemanuf;

    public Integer getIdmanuf() {
        return idmanuf;
    }

    public void setIdmanuf(Integer idmanuf) {
        this.idmanuf = idmanuf;
    }

    public String getNamemanuf() {
        return namemanuf;
    }

    public void setNamemanuf(String namemanuf) {
        this.namemanuf = namemanuf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManufactureEntity that = (ManufactureEntity) o;
        return Objects.equals(idmanuf, that.idmanuf) &&
                Objects.equals(namemanuf, that.namemanuf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmanuf, namemanuf);
    }
}
