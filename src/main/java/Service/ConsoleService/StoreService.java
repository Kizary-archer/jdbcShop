package Service.ConsoleService;

import DTO.UserOrderViewEntity;
import Service.UserService;
import Util.ScannerFactoryUtil;

import java.util.List;
import java.util.Scanner;

public class StoreService {
    private final UserService userService;
    Scanner scanner = ScannerFactoryUtil.getScanner();

    public StoreService(UserService userService) {
        this.userService = userService;
    }

    public void run() {
        try {
            while (true) {
                System.out.println("Выберите действие:\n0)Выйти\n1)Заказать\n2)Список Заказов\n3)Удалить заказ");
                switch (scanner.nextInt()) {
                    case 0:
                        return;
                    case 1:
                        // authorization();
                        break;
                    case 2:
                        userOrderList();
                        break;
                    case 3:
                        delOrder();
                        break;
                    default:
                        System.out.println("Такой команды нет");
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

    private void delOrder() {
        System.out.println("Введите номер заказа");
        if(userService.deleteUserOrder(scanner.nextInt())) System.out.println("Заказ удалён");
        else System.out.println("Данного заказа не существует");
    }
}

