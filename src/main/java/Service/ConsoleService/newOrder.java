package Service.ConsoleService;

import Service.UserService;
import Util.ScannerFactoryUtil;

import java.util.Scanner;

public class newOrder {
    private final UserService userService;
    Scanner scanner = ScannerFactoryUtil.getScanner();

    public newOrder(UserService userService) {
        this.userService = userService;
    }
}
