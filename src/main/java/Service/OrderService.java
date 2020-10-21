package Service;

import DAO.IDAO.IDAO;
import DAO.IDAO.IProductDAO;
import DAO.IDAO.IUserOrderDAO;
import DAO.ManufactureDAOImpl;
import DAO.ProductDAOImpl;
import DAO.ProductTypeDAOImpl;
import DAO.UserOrderDAOImpl;
import DTO.ManufactureEntity;
import DTO.ProdTypeEntity;
import DTO.ProductViewEntity;
import DTO.UserOrderEntity;

import java.util.List;

public class OrderService {
    IDAO<ProdTypeEntity> productTypeDAO = new ProductTypeDAOImpl();
    IDAO<ManufactureEntity> manufactureDAO = new ManufactureDAOImpl();
    IProductDAO productDAO = new ProductDAOImpl();
    IUserOrderDAO userOrderDAO = new UserOrderDAOImpl();


    public List<ProdTypeEntity> prodTypeList(){
        return productTypeDAO.list();
    }
    public List<ManufactureEntity> manufList(){
        return manufactureDAO.list();
    }
    public List<ProductViewEntity> prodViewList(){
        return productDAO.productViewList();
    }
    public boolean addOrder(UserOrderEntity orderEntity){
        return userOrderDAO.add(orderEntity);
    }
}
