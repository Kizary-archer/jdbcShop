package Service;

import DAO.IDAO.IDAO;
import DAO.ManufactureDAOImpl;
import DAO.ProductTypeDAOImpl;
import DTO.ManufactureEntity;
import DTO.ProdTypeEntity;

import java.util.List;

public class OrderService {
    IDAO<ProdTypeEntity> productTypeDAO = new ProductTypeDAOImpl();
    IDAO<ManufactureEntity> manufactureDAO = new ManufactureDAOImpl();

    public List<ProdTypeEntity> prodTypeList(){
        return productTypeDAO.list();
    }
    public List<ManufactureEntity> manufList(){
        return manufactureDAO.list();
    }
}
