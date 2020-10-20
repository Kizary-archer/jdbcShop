package Service;

import DAO.IUserDAO;
import DAO.IUserOrderDAO;
import DAO.UserDAOImpl;
import DAO.UserOrderDAOImpl;
import DTO.UserEntity;
import DTO.UserOrderViewEntity;
import DTOBuilder.UserBuilder;

import java.util.List;
import java.util.Objects;

public class UserService {
    private final IUserDAO userDAO = new UserDAOImpl();
    private final IUserOrderDAO userOrderDAO = new UserOrderDAOImpl();
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public boolean authorization(UserEntity userEntity) {
        try {
            user = userDAO.getUserByLogin(userEntity.getLogin());
            if (user != null && Objects.equals(user.getPassword(), userEntity.getPassword()))
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registration(UserEntity userEntity) {
        try {
            return userDAO.add(new UserBuilder()
                    .setLogin(userEntity.getLogin())
                    .setPassword(userEntity.getPassword())
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<UserOrderViewEntity> getUserOrder(){
        return userOrderDAO.listUserOrder(user);
    }
}
