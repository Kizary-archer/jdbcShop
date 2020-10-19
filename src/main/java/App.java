import DAO.UserDAOImpl;
import Util.DBConnectUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        UserDAOImpl userDAO = new UserDAOImpl();
        userDAO.list();

    }
}
