package DAO.IDAO;

import DTO.UserEntity;

public interface IUserDAO extends IDAO<UserEntity> {
    public UserEntity getUserByLogin(String login);
}
