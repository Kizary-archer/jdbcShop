package DTO;

import java.util.Objects;

public class UserEntity {
    private Integer iduser;
    private String login;
    private String password;

    public UserEntity() {
    }

    public UserEntity(Integer id, String login, String pass) {
        this.iduser = id;
        this.login = login;
        this.password = pass;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(iduser, that.iduser) &&
                Objects.equals(login, that.login) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iduser, login, password);
    }
}
