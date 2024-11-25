package ui;

import mobelLoadStrategy.StrategyType;
import service.ServiceImpl;
import java.util.Scanner;
/**
 * Класс реализация пользовательского интерфейса.
 * @autor Виктор Дробышевский
 * @version 0.8
 */

public class UI_impl implements UI{
    private final ServiceImpl service = new ServiceImpl();
    private final Scanner in = new Scanner(System.in);

    @Override
    public void runner() {
        String operations = "";

        boolean work = true;
        System.out.println("Добро пожаловать.");
        help();

        while (work) {
            operations = in.next();
            if (operations.trim().matches("\\d")) {
                int op = Integer.parseInt(operations);
                switch (op) {
                    case 1:
                        load();
                        break;
                    case 2:
                        look();
                        break;
                    case 3:
                        search();
                        break;
                    case 4:
                        help();
                        break;
                    case 5:
                        work = false;
                        break;
                    default:
                        System.out.println("Выбран несуществующий пункт меню, попробуйте обратиться в раздел помощи. 4 для отображения доступных операций.");
                }
            } else
                System.out.println("Введена неподдерживаемая команда попробуйте обратиться в раздел помощи. 4 для отображения доступных операций.");
        }
    }

    @Override
    public void close() {
        in.close();
    }

    @Override
    public void load() {
        System.out.println("Процесс загрузки элементов");
        String operations = "";

        System.out.println("1\tЗагрузка из файла");
        System.out.println("2\tзагрузка из консоли");
        System.out.println("3\tЗаполнение N случайными элементами");
        System.out.println("Ввод для возврата в главное меню");

        operations = in.next();
        operations.trim().matches("\\d");

        switch (operations) {
                case "1":
                    service.loadModels(StrategyType.FILE);
                    break;
                case "2":
                    service.loadModels(StrategyType.USER);
                    break;
        }
        in.close();
    }

    @Override
    public void search() {
        System.out.println("Поиск элемента в загруженной коллекции");
        String  searchModel = in.next();
        service.searchModel(searchModel);

    }

    @Override
    public void help() {
        System.out.println("1\tДля загрузки элементов");
        System.out.println("\t1\tЗагрузка из файла");
        System.out.println("\t2\tзагрузка из консоли");
        System.out.println("\t3\tЗаполнение N случайными элементами");
        System.out.println("2\tДля просмотра загруженной коллекции");
        System.out.println("3\tДля поиска элемента");
        System.out.println("4\tПомощь");
        System.out.println("5\tВыход");
    }

    @Override
    public void look() {
        if (!service.getModelList().isEmpty()){
            service.getModelList().forEach(System.out::println);
        } else
            System.out.println("Элементы отсутствуют, возврат в главное меню");
    }
}