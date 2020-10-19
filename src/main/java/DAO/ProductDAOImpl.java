package DAO;

import DTO.ProductEntity;
import DTO.UserEntity;
import DTOBuilder.ProductBuilder;
import DTOBuilder.UserBuilder;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ProductDAOImpl implements IDAO<ProductEntity> {
    @Override
    public boolean add(ProductEntity productEntity) throws SQLException {
        Connection connection = getConnection();
        try {
            String sql = "INSERT INTO public.product (nameprod,manufacture,\"type\",price) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productEntity.getNameprod());
            preparedStatement.setInt(2, productEntity.getManufacture());
            preparedStatement.setInt(3, productEntity.getType());
            preparedStatement.setLong(4, productEntity.getPrice());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean del(ProductEntity productEntity) {
        Connection connection = getConnection();
        try {
            String sql = "delete from public.product where idproduct = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productEntity.getIdproduct());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Map<Integer, ProductEntity> list() throws SQLException {
        Map<Integer, ProductEntity> res = new HashMap<>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "select distinct * from public.product";
            ResultSet ps = statement.executeQuery(sql);
            while (ps.next()) {
                ProductEntity product = new ProductBuilder()
                        .setIdproduct(ps.getInt("idproduct"))
                        .setNameprod(ps.getString("nameprod"))
                        .setManufacture(ps.getInt("manufacture"))
                        .setType(ps.getInt("type"))
                        .setPrice(ps.getLong("price"))
                        .build();
                res.putIfAbsent(product.getIdproduct(), product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
