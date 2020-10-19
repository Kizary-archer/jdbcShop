package DTOBuilder;

import DTO.UserEntity;

public class UserBuilder {

    private Integer iduser;
    private String login;
    private String password;

    public UserBuilder setIduser(Integer iduser) {
        this.iduser = iduser;
        return this;
    }

    public UserBuilder setLogin(String login) {
        this.login = login;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserEntity build(){
        return new UserEntity(iduser,login,password);
    }
}
