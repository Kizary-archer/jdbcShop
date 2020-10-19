package DAO;

import Util.DBConnectUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface IDAO<T> {
    default Statement getStatement() {
        try (Connection connection = DBConnectUtil.getConnection()) {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    void add(T t);
    void del(T t);
    void upd(T t);
}
