package Service.ConsoleService;

import DTO.UserEntity;
import Service.UserService;
import Util.ScannerFactoryUtil;

import java.util.Scanner;

public class StoreService {
    private UserService userService;

    public StoreService(UserService userService) {
        this.userService = userService;
    }

    public void run() {
        try (Scanner scanner = ScannerFactoryUtil.getScanner()) {
            while (true) {
                System.out.println("Выберите действие:\n0)Завершить работу\n1)Войти\n2)Зарегистрироваться");
                switch (scanner.nextInt()) {
                    case 0:
                        return;
                    case 1:
                        authorization();
                        break;
                    case 2:
                        registration();
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

    }
}
