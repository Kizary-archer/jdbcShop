package DAO;

import DAO.IDAO.IProductDAO;
import DTO.ProductEntity;
import DTO.ProductViewEntity;
import DTOBuilder.ProductBuilder;
import DTOBuilder.ProductViewBuilder;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductDAOImpl implements IProductDAO {
    @Override
    public boolean add(ProductEntity productEntity){
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
    public List<ProductEntity> list() {
        List<ProductEntity> res = new LinkedList<>();
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
                res.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public List<ProductViewEntity> productViewList() {
        List<ProductViewEntity> res = new LinkedList<>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "select distinct * from public.productview";
            ResultSet ps = statement.executeQuery(sql);
            while (ps.next()) {
                ProductViewEntity productView = new ProductViewBuilder()
                        .setIdproduct(ps.getInt("idproduct"))
                        .setNameprod(ps.getString("nameprod"))
                        .setNamemanuf(ps.getString("namemanuf"))
                        .setTypename(ps.getString("typename"))
                        .setPrice(ps.getLong("price"))
                        .build();
                res.add(productView);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
