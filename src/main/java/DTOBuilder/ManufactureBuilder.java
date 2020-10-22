package DTOBuilder;

import Entityes.ManufactureEntity;

public class ManufactureBuilder {
    private Integer idmanuf;
    private String namemanuf;

    public ManufactureBuilder setIdmanuf(Integer idmanuf) {
        this.idmanuf = idmanuf;
        return this;
    }

    public ManufactureBuilder setNamemanuf(String namemanuf) {
        this.namemanuf = namemanuf;
        return this;
    }
    public ManufactureEntity build(){
        return new ManufactureEntity(idmanuf,namemanuf);
    }
}
