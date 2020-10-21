package DAO;

import DAO.IDAO.IUserOrderDAO;
import DTO.UserEntity;
import DTO.UserOrderEntity;
import DTO.UserOrderViewEntity;
import DTOBuilder.UserOrderBuilder;
import DTOBuilder.UserOrderViewBuilder;

import java.sql.*;
import java.util.*;

public class UserOrderDAOImpl implements IUserOrderDAO {

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
            String sql = "delete from public.userorder where idorder = ? and \"user\" = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userOrderEntity.getIdorder());
            preparedStatement.setInt(2, userOrderEntity.getUser());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<UserOrderEntity> list() {
        List<UserOrderEntity> res = new LinkedList<>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "select distinct * from public.userorder order by idorder";
            ResultSet uos = statement.executeQuery(sql);
            while (uos.next()) {
                UserOrderEntity uOrder = new UserOrderBuilder()
                        .setIdorder(uos.getInt("idorder"))
                        .setIdorder(uos.getInt("user"))
                        .setIdorder(uos.getInt("product"))
                        .setIdorder(uos.getInt("count"))
                        .build();
                res.add(uOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public List<UserOrderViewEntity> listUserOrder(UserEntity userEntity) {
        List<UserOrderViewEntity> res = new LinkedList<>();
        try {
            String sql = "select distinct * from public.userorderview where \"user\" = ? order by idorder";
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, userEntity.getIduser());
            ResultSet uos = preparedStatement.executeQuery();
            while (uos.next()) {
                UserOrderViewEntity uOrder = new UserOrderViewBuilder()
                        .setIdorder(uos.getInt("idorder"))
                        .setNameprod(uos.getString("nameprod"))
                        .setTypename(uos.getString("typename"))
                        .setNamemanuf(uos.getString("namemanuf"))
                        .setPrice(uos.getLong("price"))
                        .setCount(uos.getInt("count"))
                        .setFinalprice(uos.getLong("finalprice"))
                        .build();
                res.add(uOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
