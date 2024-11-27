package ui;

import mobelLoadStrategy.StrategyType;
import model.impl.Model;
import model.ModelType;
import service.ServiceImpl;

import java.util.List;
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
        String operations;

        boolean work = true;
        System.out.println("Добро пожаловать.");
        help();

        while (work) {
            operations = in.next();
            if (operations.trim().matches("\\d")) {
                int op = Integer.parseInt(operations);
                switch (op) {
                    case 1:
                    {
                        load();
                        break;
                    }
                    case 2: {
                        look();
                        break;
                    }
                    case 3:
                    {
                        search();
                        break;
                    }
                    case 4:
                    {
                        help();
                        break;
                    }
                    case 5:
                    {
                        work = false;
                        break;
                    }

                    default:

                        System.out.println("Выбран несуществующий пункт меню, попробуйте обратиться в раздел помощи. 4 для отображения доступных операций.");
                }
            } else
                System.out.println("Введена неподдерживаемая команда попробуйте обратиться в раздел помощи. 4 для отображения доступных операций.");
        }
    }

    @Override
    public void close() {in.close();
    }

    @Override
    public void load() {
        System.out.println("Процесс загрузки элементов");

        System.out.println("1\tЗагрузка из файла");
        System.out.println("2\tзагрузка из консоли");
        System.out.println("3\tЗаполнение N случайными элементами");
        System.out.println("Ввод для возврата в главное меню");

        int operations = in.nextInt();

                switch (operations) {
                case 1:
                    service.loadModels(StrategyType.FILE, null);
                    break;
                case 2:
                    service.loadModels(StrategyType.USER, null);
                    break;
                case 3: {
                    ModelType type = null;
                    while (type == null) {
                        type = modelType();
                        if (type == null) {
                            System.out.println("""
                                    Выполнить повторный поиск
                                    1\tДа
                                    Любая клавиша для возврата в главное меню
                                    """);
                            if (in.nextInt()!=1) {System.out.println("Возврат в главное меню\n");
                                return;}
                        }
                    }
                    service.loadModels(StrategyType.RANDOM, type);
                    break;
                }
        }
    }

    @Override
    public void search() {
        if (!service.isEmpty()) {
            String operations;
            String  searchModel = "";
            System.out.println("Поиск элемента в загруженной коллекции");
            System.out.println("1\tАвтобус");
            System.out.println("2\tПользователь");
            System.out.println("3\tСтудент");
            operations = in.next();
            operations.trim().matches("\\d");

            switch (operations) {
                case "1" : {
                    System.out.println("Для поиска автобуса необходимо указать его номер в соответствии с форматом:");
                    System.out.println("формат согласно валидации");
                    searchModel = in.next();
                    // валидация
                    //if (notValid) System.out.println("Введенное значение не соответствует формату");
                    break;
                }
                case "2" : {
                    System.out.println("Для поиска пользователя необходимо указать его имя в соответствии с форматом:");
                    System.out.println("формат согласно валидации");
                    searchModel = in.next();
                    // валидация
                    break;
                }

                case "3" : {
                    System.out.println("Для поиска студента необходимо указать его номер зачетной книжки в соответствии с форматом:");
                    System.out.println("формат согласно валидации");
                    searchModel = in.next();
                    // валидация
                    break;
                }
            }

            List<Model> search = service.searchModel(searchModel);

            if (!search.isEmpty()) {search.forEach(System.out::println);}
            else System.out.println("Искомый элемент не найден");
        } else System.out.println("В программе отсутствуют значения, поиск невозможен. Сначала загрузите элементы.");
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
        if (!service.isEmpty()){
            service.getModelList().forEach(System.out::println);
        } else
            System.out.println("Элементы отсутствуют, возврат в главное меню");
    }

    private ModelType modelType () {
        System.out.println("Выберете тип загружаемой модели:");
        System.out.println("1\tАвтобус");
        System.out.println("2\tПользователь");
        System.out.println("3\tСтудент");

        int operations = in.nextInt();
        return switch (operations) {
            case 1 -> ModelType.BUS;
            case 2 -> ModelType.USER;
            case 3 -> ModelType.STUDENT;
            default -> null;
        };
    }

}