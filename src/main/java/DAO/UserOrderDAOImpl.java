package DAO;

import DTO.UserEntity;
import DTO.UserOrderEntity;
import DTOBuilder.UserBuilder;
import DTOBuilder.UserOrderBuilder;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class UserOrderDAOImpl implements IDAO<UserOrderEntity> {

    @Override
    public boolean add(UserOrderEntity userOrderEntity) {
        Connection connection = getConnection();
        try {
            String sql = "INSERT INTO public.userorder (\"user\",product,count) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userOrderEntity.getUser());
            preparedStatement.setInt(2, userOrderEntity.getProduct());
            preparedStatement.setInt(3, userOrderEntity.getCount());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean del(UserOrderEntity userOrderEntity) {
        Connection connection = getConnection();
        try {
            String sql = "delete from public.userorder where idorder = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userOrderEntity.getIdorder());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Map<Integer, UserOrderEntity> list() {
        Map<Integer, UserOrderEntity> res = new HashMap<>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "select distinct * from public.userorder";
            ResultSet uos = statement.executeQuery(sql);
            while (uos.next()) {
                UserOrderEntity uOrder = new UserOrderBuilder()
                        .setIdorder(uos.getInt("idorder"))
                        .setIdorder(uos.getInt("user"))
                        .setIdorder(uos.getInt("product"))
                        .setIdorder(uos.getInt("count"))
                        .build();
                res.putIfAbsent(uOrder.getIdorder(), uOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public Map<Integer, UserOrderEntity> listUserOrder(UserEntity userEntity) {
        Map<Integer, UserOrderEntity> res = new HashMap<>();
        try {
            String sql = "select distinct * from public.userorder where \"user\" = ?";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, userEntity.getIduser());
            ResultSet uos = preparedStatement.executeQuery(sql);
            while (uos.next()) {
                UserOrderEntity uOrder = new UserOrderBuilder()
                        .setIdorder(uos.getInt("idorder"))
                        .setIdorder(uos.getInt("user"))
                        .setIdorder(uos.getInt("product"))
                        .setIdorder(uos.getInt("count"))
                        .build();
                res.putIfAbsent(uOrder.getIdorder(), uOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
