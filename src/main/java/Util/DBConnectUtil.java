package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectUtil {
    private static Connection connection;
    private static final String url = "jdbc:postgresql://localhost:5432/Shop";
    private static final String user = "postgres";
    private static final String pass = "1475963";

    private DBConnectUtil() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed())
                return connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
