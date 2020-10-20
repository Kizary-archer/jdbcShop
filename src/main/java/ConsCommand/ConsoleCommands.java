//package ConsCommand;
//
//import ProductBuilders.MicrophoneBuilder;
//import ProductBuilders.SmartphoneBuilder;
//import ProductEntityes.Microphone;
//import ProductEntityes.Product;
//import ProductEntityes.Smartphone;
//import ProductFactory.MicrophoneFactory;
//import ProductFactory.ProductFactory;
//import ProductFactory.SmartphoneFactory;
//import Util.ProductList;
//import Util.ScannerFactoryUtil;
//
//import java.util.Scanner;
//
//public class ConsoleCommands {// приёмник команд receiver
//
//    Product p;
//    Scanner scanner = ScannerFactoryUtil.getScanner();
//
//    public void add() {
//        ProductFactory productFactory;
//        System.out.println("Выберите продукт:\n0)Отмена\n1)Смартфон\n2)Микрофон");
//        try {
//            switch (scanner.nextInt()) {
//                case 0:
//                    return;
//                case 1:
//                    System.out.println("Введите данные о смартфоне");
//                    productFactory = new SmartphoneFactory();
//                    SmartphoneBuilder smbuilder = new SmartphoneBuilder((Smartphone) productFactory.createProduct());
//                    System.out.println("введите производителя:");
//                    smbuilder.setManufactore(scanner.next());
//                    System.out.println("введите модель");
//                    smbuilder.setModel(scanner.next());
//                    System.out.println("введите цену");
//                    if (scanner.hasNextInt()) smbuilder.setPrise(scanner.nextInt());
//                    else {
//                        System.out.println("Ошибка ввода - продукт не создан");
//                        break;
//                    }
//                    System.out.println("введите диагональ экрана");
//                    if (scanner.hasNextInt()) smbuilder.setDiagonal(scanner.nextInt());
//                    else {
//                        System.out.println("Ошибка ввода - продукт не создан");
//                        break;
//                    }
//                    p = smbuilder.build();    //получаем продукт
//                    ProductList.getProductList().put(p.getManufacture() + p.getModel(), p);//добавляем в список(ключ-производитель+модель)
//                    System.out.println("Смартфон успешно добавлен");
//                    break;
//                case 2:
//                    System.out.println("Введите данные о микрофоне");
//                    productFactory = new MicrophoneFactory();
//                    MicrophoneBuilder micbuilder = new MicrophoneBuilder((Microphone) productFactory.createProduct());
//                    System.out.println("введите производителя:");
//                    micbuilder.setManufactore(scanner.next());
//                    System.out.println("введите модель");
//                    micbuilder.setModel(scanner.next());
//                    System.out.println("введите цену");
//                    if (scanner.hasNextInt()) micbuilder.setPrise(scanner.nextInt());
//                    else {
//                        System.out.println("Ошибка ввода - продукт не создан");
//                        break;
//                    }
//                    System.out.println("введите тип разъёма");
//                    micbuilder.setConnector(scanner.next());
//                    p = micbuilder.build();    //получаем продукт
//                    ProductList.getProductList().put(p.getManufacture() + p.getModel(), p);//добавляем в список
//                    System.out.println("Микрофон успешно добавлен");
//                    break;
//                default:
//                    System.out.println("Продукт введён некоректно");
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void del() {
//        if(ProductList.getProductList().size() == 0){
//            System.out.println("Список продуктов пуст\n");
//            return;
//        }
//        System.out.println("Введите производителя и модель удаляемого продукта");
//        try {
//            System.out.println("введите производителя:");
//            String manuf = scanner.next();
//            System.out.println("введите модель");
//            String model = scanner.next();
//            ProductList.getProductList().remove(manuf.concat(model)); //удаление продукта по производителю и модели
//            System.out.println("Продукт успешно удалён");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public void list() {
//        if(ProductList.getProductList().size() == 0){
//            System.out.println("Список продуктов пуст\n");
//            return;
//        }
//        System.out.println("Список продуктов:");
//        ProductList.getProductList().forEach((k, v) ->
//                System.out.printf("Модель: %s\nПроизводитель: %s\nЦена: %d руб\nТип: %s",
//                        v.getModel(), v.getManufacture(), v.getPrice(), v.getType()
//                                + "\n---------------------------\n"));
//    }
//}
