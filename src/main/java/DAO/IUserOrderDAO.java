package DAO;

import DTO.UserEntity;
import DTO.UserOrderEntity;
import DTO.UserOrderViewEntity;

import java.util.List;

public interface IUserOrderDAO extends IDAO<UserOrderEntity>{
    public List<UserOrderViewEntity> listUserOrder(UserEntity userEntity);
}
