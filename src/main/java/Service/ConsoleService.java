package Service;

import DTO.UserEntity;
import DTOBuilder.UserBuilder;
import Util.ScannerFactoryUtil;

import java.util.Scanner;

public class ConsoleService {
    UserService userService = new UserService();

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

    private boolean authorization() {
        System.out.println("Авторизация");
        if (userService.authorization(inputLogAndPass())) {
            System.out.println("Авторизация прошла успешно");
            return true;
        } else {
            System.out.println("Авторизация прошла неуспешно\nНеправильный логин или пароль");
            return false;
        }
    }

    private boolean registration() {
        System.out.println("Регистрация");
        if (userService.registration(inputLogAndPass())) {
            System.out.println("Регистрация прошла успешно");
            return true;
        } else {
            System.out.println("Регистрация прошла неуспешно\nПопробуйте ввести другой логин");
            return false;
        }
    }

    private UserEntity inputLogAndPass() {
        Scanner scanner = ScannerFactoryUtil.getScanner();
        UserBuilder user = new UserBuilder();
        System.out.println("Введите логин");
        user.setLogin(scanner.next());
        System.out.println("Введите пароль");
        user.setPassword(scanner.next());
        return user.build();
    }
}
