package Util;

import java.util.Scanner;

public class ScannerFactoryUtil {
    private static Scanner scanner;

    private ScannerFactoryUtil(){};
    public static Scanner getScanner() {
        if (scanner == null) {
             scanner = new Scanner(System.in);
        }
        return scanner;
    }
}