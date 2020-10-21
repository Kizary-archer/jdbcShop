package DAO;

import DAO.IDAO.IDAO;
import DTO.ProdTypeEntity;
import DTOBuilder.ProdTypeBuilder;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ProductTypeDAOImpl implements IDAO<ProdTypeEntity> {

    @Override
    public boolean add(ProdTypeEntity prodTypeEntity) {
        Connection connection = getConnection();
        try {
            String sql = "INSERT INTO public.prodtype (typename) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, prodTypeEntity.getTypename());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean del(ProdTypeEntity prodTypeEntity) {
        Connection connection = getConnection();
        try {
            String sql = "delete from public.prodtype where idtype = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, prodTypeEntity.getIdtype());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ProdTypeEntity> list() {
        List<ProdTypeEntity> res = new LinkedList<>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "select distinct * from public.prodtype order by idtype";
            ResultSet pts = statement.executeQuery(sql);
            while (pts.next()) {
                ProdTypeEntity pType = new ProdTypeBuilder()
                        .setIdtype(pts.getInt("idtype"))
                        .setTypename(pts.getString("typename"))
                        .build();
                res.add(pType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
