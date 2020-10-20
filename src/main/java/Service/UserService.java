package Service;

import DAO.IUserDAO;
import DAO.UserDAOImpl;
import DTO.ProductEntity;
import DTO.UserEntity;
import DTO.UserOrderEntity;
import DTOBuilder.UserBuilder;

import java.util.Map;
import java.util.Objects;

public class UserService {
    IUserDAO userDAO = new UserDAOImpl();
    UserEntity user;

    public boolean authorization(String login, String password) {
        try {
            user = userDAO.getUserByLogin(login);
            if (user != null && Objects.equals(user.getPassword(), password))
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registration(String login, String password) {
        try {
            return userDAO.add(new UserBuilder()
                    .setLogin(login)
                    .setPassword(password)
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
//    public Map<Integer, UserOrderEntity> getUserOrder(){
//
//    }
}
