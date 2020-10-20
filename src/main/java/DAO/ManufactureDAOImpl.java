package DAO;

import DTO.ManufactureEntity;
import DTO.UserEntity;
import DTOBuilder.ManufactureBuilder;
import DTOBuilder.UserBuilder;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ManufactureDAOImpl implements IDAO<ManufactureEntity> {

    @Override
    public boolean add(ManufactureEntity manufactureEntity) {
        Connection connection = getConnection();
        try {
            String sql = "INSERT INTO public.manufacture (namemanuf) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, manufactureEntity.getNamemanuf());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean del(ManufactureEntity manufactureEntity) {
        Connection connection = getConnection();
        try {
            String sql = "delete from public.manufacture where idmanuf = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, manufactureEntity.getIdmanuf());
            if (preparedStatement.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Map<Integer, ManufactureEntity> list() {
        Map<Integer, ManufactureEntity> res = new HashMap<>();
        try {
            Statement statement = getConnection().createStatement();
            String sql = "select distinct * from public.manufacture";
            ResultSet ms = statement.executeQuery(sql);
            while (ms.next()) {
                ManufactureEntity manuf = new ManufactureBuilder()
                        .setIdmanuf(ms.getInt("idmanuf"))
                        .setNamemanuf(ms.getString("namemanuf"))
                        .build();
                res.putIfAbsent(manuf.getIdmanuf(), manuf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
