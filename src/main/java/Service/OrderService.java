package Service;

import DAO.IDAO.IProductDAO;
import DAO.IDAO.IUserOrderDAO;
import DAO.ProductDAOImpl;
import DAO.UserOrderDAOImpl;
import DTO.ProductViewEntity;
import DTO.UserEntity;
import DTO.UserOrderEntity;
import DTO.UserOrderViewEntity;

import java.util.List;

public class OrderService {//сервис работы с заказами пользователя
    IProductDAO productDAO = new ProductDAOImpl();
    IUserOrderDAO userOrderDAO = new UserOrderDAOImpl();


    public List<ProductViewEntity> prodViewList() {//вывод списка товаров
        return productDAO.productViewList();
    }

    public boolean addOrder(UserOrderEntity orderEntity) {//заказ товара
        return userOrderDAO.add(orderEntity);
    }

    public List<UserOrderViewEntity> getUserOrder(UserEntity user) {//вывод списка заказов пользователя
        return userOrderDAO.listUserOrder(user);
    }

    public boolean deleteUserOrder(UserOrderEntity userOrderEntity) {//удаление заказа
        return userOrderDAO.del(userOrderEntity);
    }
}
