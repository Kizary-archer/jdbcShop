package DAO;

import DAO.IDAO.IUserDAO;
import DTO.UserEntity;
import DTOBuilder.UserBuilder;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {

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

    public UserEntity getUserByLogin(String login) {
        Connection connection = getConnection();
        try {
            String sql = "select * from public.\"user\" where login = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            return new UserBuilder()
                    .setIduser(rs.getInt("iduser"))
                    .setLogin(rs.getString("login"))
                    .setPassword(rs.getString("password"))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<UserEntity> list() {
        List<UserEntity> res = new LinkedList<>();
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
                res.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
