package App.Service;

import App.DAO.IDAO.UserDAO;
import App.DAO.UserDAOImpl;
import App.Entities.UserEntity;
import org.mindrot.jbcrypt.BCrypt;

public class UserService {
    UserDAO userDAO = new UserDAOImpl();
    public UserEntity authorization (UserEntity usersEntity){
        String pass = usersEntity.getPassword();
        UserEntity user = userDAO.getUserByLogin(usersEntity.getLogin());
        if(BCrypt.checkpw(pass, user.getPassword()))return user;
        else return null;
    }
    public boolean registration(String login,String pass){
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(login);
        userEntity.setPassword(BCrypt.hashpw(userEntity.getPassword(), BCrypt.gensalt(12)));//кодирование пароля
        return userDAO.add(userEntity);
    }
}
