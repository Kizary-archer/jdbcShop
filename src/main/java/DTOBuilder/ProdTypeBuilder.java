package DTOBuilder;

import DTO.ProdTypeEntity;

public class ProdTypeBuilder {
    private Integer idtype;
    private String typename;

    public ProdTypeBuilder setIdtype(Integer idtype) {
        this.idtype = idtype;
        return this;
    }

    public ProdTypeBuilder setTypename(String typename) {
        this.typename = typename;
        return this;
    }
    public ProdTypeEntity build(){
        return new ProdTypeEntity(idtype,typename);
    }
}
