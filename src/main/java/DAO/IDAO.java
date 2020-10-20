package DAO;

import Util.DBConnectUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public interface IDAO<T> {
    default Connection getConnection() {
        return DBConnectUtil.getConnection();
    }
    boolean add(T t) throws SQLException;
    boolean del(T t);
    List<T> list() throws SQLException;
}
