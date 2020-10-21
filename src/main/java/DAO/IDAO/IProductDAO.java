package DAO.IDAO;

import DTO.ProductEntity;
import DTO.ProductViewEntity;

import java.util.List;

public interface IProductDAO extends IDAO<ProductEntity> {
    List<ProductViewEntity> productViewList();
}
