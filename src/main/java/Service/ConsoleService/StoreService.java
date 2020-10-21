package Service.ConsoleService;

import DTO.UserOrderViewEntity;
import Service.UserService;
import Util.ScannerFactoryUtil;

import java.util.List;
import java.util.Scanner;

public class StoreService {
    private UserService userService;

    public StoreService(UserService userService) {
        this.userService = userService;
    }

    public void run() {
        Scanner scanner = ScannerFactoryUtil.getScanner();
        try {
            while (true) {
                System.out.println("Выберите действие:\n0)Выйти\n1)Заказать\n2)Список Заказов");
                switch (scanner.nextInt()) {
                    case 0:
                        return;
                    case 1:
                        // authorization();
                        break;
                    case 2:
                        userOrderList();
                        break;
                    default:
                        System.out.println("как ты попал сюда дядя!!!");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void userOrderList() {
        List<UserOrderViewEntity> orderList = userService.getUserOrder();
        if (orderList.size() == 0) {
            System.out.println("Корзина пуста\n");
            return;
        }
        System.out.println("Список товаров:\n---------------------------");
        orderList.forEach(v ->
                System.out.printf("Номер %d\nНазвание: %s\nПроизводитель: %s\nТип: %s\nЦена за шт: %d руб\nКоличество: %d\nИтоговая цена: %s",
                        v.getIdorder(), v.getNameprod(), v.getNamemanuf(), v.getTypename(), v.getPrice(), v.getCount(), v.getFinalprice()
                                + " руб\n---------------------------\n"));
    }
}

