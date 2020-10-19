package DAO;

import DTO.UserEntity;
import DTOBuilder.UserBuilder;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserDAOImpl implements IDAO<UserEntity> {

    @Override
    public boolean add(UserEntity userEntity) {
        Connection connection = getConnection();
        try {
            String sql = "INSERT INTO public.\"user\" (login,\"password\") VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userEntity.getLogin());
            preparedStatement.setString(2, userEntity.getPassword());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean del(UserEntity userEntity) {
        Connection connection = getConnection();
        try {
            String sql = "delete from public.\"user\" where iduser = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userEntity.getIduser());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Map<Integer, UserEntity> list() {
        Map<Integer, UserEntity> res = new HashMap<>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "select distinct * from public.\"user\"";
            ResultSet us = statement.executeQuery(sql);
            while (us.next()) {
                UserEntity user = new UserBuilder()
                        .setIduser(us.getInt("iduser"))
                        .setLogin(us.getString("login"))
                        .setPassword(us.getString("password"))
                        .build();
                res.putIfAbsent(user.getIduser(), user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
