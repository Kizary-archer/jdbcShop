import DAO.UserDAOImpl;
import Service.ConsoleService;
import Util.DBConnectUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        ConsoleService consoleService = new ConsoleService();
        consoleService.run();
    }
}
