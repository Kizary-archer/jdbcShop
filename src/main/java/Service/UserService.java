package Service;

import DAO.IDAO.IUserDAO;
import DAO.IDAO.IUserOrderDAO;
import DAO.UserDAOImpl;
import DAO.UserOrderDAOImpl;
import DTO.UserEntity;
import DTOBuilder.UserBuilder;

import java.util.Objects;

public class UserService {//сервис отвечающий за регистрацию и авторизацию(хранит авторизованного пользователя)
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
}

