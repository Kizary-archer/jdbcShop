package Service.ConsoleService;

import DTO.UserOrderEntity;
import DTO.UserOrderViewEntity;
import DTOBuilder.ProductBuilder;
import DTOBuilder.UserOrderBuilder;
import Service.OrderService;
import Service.UserService;
import Util.ScannerFactoryUtil;

import java.util.List;
import java.util.Scanner;

public class StoreService {
    private final UserService userService;
    Scanner scanner = ScannerFactoryUtil.getScanner();
    private final OrderService orderService = new OrderService();

    public StoreService(UserService userService) {
        this.userService = userService;
    }

    public void run() {//вторая страница магазина с функциями управления заказами пользователя
        try {
            while (true) {
                System.out.println("Выберите действие:\n0)Выйти\n1)Заказать\n2)Список Заказов\n3)Удалить заказ");
                switch (scanner.nextInt()) {
                    case 0:
                        return;
                    case 1:
                        addOrder();
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
            System.out.println("команда введена неверно ");
        }
    }

    private void userOrderList() {
        List<UserOrderViewEntity> orderList = orderService.getUserOrder(userService.getUser());
        if (orderList.size() == 0) {
            System.out.println("Корзина пуста\n");
            return;
        }
        System.out.println("Список Заказов:\n---------------------------");
        orderList.forEach(v ->
                System.out.printf("Номер %d\nНазвание: %s\nПроизводитель: %s\nТип: %s\nЦена за шт: %d руб\nКоличество: %d\nИтоговая цена: %s",
                        v.getIdorder(), v.getNameprod(), v.getNamemanuf(), v.getTypename(), v.getPrice(), v.getCount(), v.getFinalprice()
                                + " руб\n---------------------------\n"));
    }

    private void delOrder() {
        System.out.println("Введите номер заказа");
        UserOrderEntity user = new UserOrderBuilder()
                .setUser(userService.getUser().getIduser())
                .setIdorder(scanner.nextInt())
                .build();
        if (orderService.deleteUserOrder(user)) System.out.println("Заказ удалён");
        else System.out.println("Данного заказа не существует");
    }

    private void addOrder() {
        try {
            OrderService orderService = new OrderService();
            UserOrderBuilder builder = new UserOrderBuilder()
                    .setUser(userService.getUser().getIduser());
            System.out.println("Список товаров\n---------------------------");
            orderService.prodViewList().forEach(v ->
                    System.out.printf("Номер %d\nНазвание: %s\nПроизводитель: %s\nТип: %s\nЦена за шт: %s ",
                            v.getIdproduct(), v.getNameprod(), v.getNamemanuf(), v.getTypename(), v.getPrice()
                                    + " руб\n---------------------------\n"));
            System.out.println("Введите номер товара\n 0)Отмена");
            int c = scanner.nextInt();
            if (c == 0) return;
            else builder.setProduct(c);
            System.out.println("Введите количество товара\n 0)Отмена");
            c = scanner.nextInt();
            if (c == 0) return;
            else builder.setCount(c);
            System.out.println("1)Оформить заказ\n0)Отмена");
            c = scanner.nextInt();
            if (c == 0) return;

            if (orderService.addOrder(builder.build())) System.out.println("Заказ успешно оформлен");
            else System.out.println("Заказ не оформлен");
        } catch (Exception e) {
            System.out.println("команда введена неверно ");
        }
    }
}

