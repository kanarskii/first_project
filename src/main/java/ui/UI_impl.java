package ui;

import mobelLoadStrategy.ServiceLoadModel;
import mobelLoadStrategy.StrategyType;
import model.Model;
import model.ModelType;
import service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Класс реализация пользовательского интерфейса.
 * @autor Виктор Дробышевский
 * @version 0.9
 */

public class UI_impl implements UI{

    private final Service service = new Service();
    private final ServiceLoadModel loader = new ServiceLoadModel();
    private final Scanner in = new Scanner(System.in);
    private ModelType type;

    @Override
    public void runner() {
        String operations;

        boolean work = true;
        System.out.println("Добро пожаловать. ");
        modelType();

        while (work) {
            menu();
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
                        sorting();
                        break;
                    }

                    case 4:
                    {
                        search();
                        break;
                    }
                    case 5:
                    {
                        modelType();
                        break;
                    }
                    case 6:
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


    private void load() {

        List<Model> models = List.of();
        System.out.println("Процесс загрузки элементов");

        System.out.println("1\tЗагрузка из файла");
        System.out.println("2\tзагрузка из консоли");
        System.out.println("3\tЗаполнение N случайными элементами");
        System.out.println(".+\t для возврата в главное меню");

        String operations = in.next();

        if (operations.trim().matches("[1-3]")) {
            switch (operations) {
                case "1" -> models = loader.loadModel(StrategyType.FILE, type);
                case "2" -> models = loader.loadModel(StrategyType.USER, type);
                case "3" -> models = loader.loadModel(StrategyType.RANDOM, type);
            }
        }

        service.addModels(models);

        sorting();
    }

    private void search() {
        if (service.empty()) {
            if (service.isSorted()) {

                Model search = null;
                String searchModel;

                switch (type) {
                    case BUS: {
                        System.out.println("Для поиска автобуса необходимо указать его номер в соответствии с форматом:");
                        System.out.println("формат согласно валидации");
                        break;
                    }
                    case USER: {
                        System.out.println("Для поиска пользователя необходимо указать его имя в соответствии с форматом:");
                        System.out.println("формат согласно валидации");
                        break;
                    }

                    case STUDENT: {
                        System.out.println("Для поиска студента необходимо указать его номер зачетной книжки в соответствии с форматом:");
                        System.out.println("формат согласно валидации");
                        break;
                    }
                }
                searchModel = in.next();

                search = service.searchModel(type, searchModel);

                if (search != null) {
                    System.out.println(search);
                } else System.out.println("Искомый элемент не найден");
            } else System.out.println("Элементы не отсортированы, поиск невозможен. Сначала отсортируйте элементы.");
        } else System.out.println("Отсутствуют элементы, поиск невозможен. Сначала загрузите элементы.");
    }


    private void menu() {
        System.out.println("1\tДля загрузки элементов");
        System.out.println("\t1\tЗагрузка из файла");
        System.out.println("\t2\tзагрузка из консоли");
        System.out.println("\t3\tЗаполнение N случайными элементами");
        System.out.println("2\tДля просмотра загруженной коллекции");
        System.out.println("3\tДля выполнения сортировки");
        System.out.println("4\tДля поиска элемента");
        System.out.println("5\tДля изменения типа элементов");
        System.out.println("6\tВыход");
    }

    private void look() {
        if (service.empty()){
            service.getModels().forEach(System.out::println);
        } else
            System.out.println("Элементы отсутствуют, возврат в главное меню");
    }

    private void modelType() {
        type = null;
        while (type == null) {
            System.out.println("Выберете модел для дальнейшей работы:");
            System.out.println("1\tАвтобус");
            System.out.println("2\tПользователь");
            System.out.println("3\tСтудент");

            String operations = in.next();

            if (operations.trim().matches("[1-3]")) {
                switch (operations) {
                    case "1" -> type = ModelType.BUS;
                    case "2" -> type = ModelType.USER;
                    case "3" -> type = ModelType.STUDENT;
                }
                service.setModels(new ArrayList<>());


                /*if (type == null) {
                    System.out.println("""
                                    Выполнить повторный поиск
                                    1\tДа
                                    Любая клавиша для возврата в главное меню
                                    """);
                    if (in.nextInt() != 1) {
                        System.out.println("Возврат в главное меню\n");
                    return;
                    }
                }*/


            }
        }
    }

    private void sorting() {
        if (service.empty()) {
            System.out.println("Выполнить сортировку элементов");
            System.out.println("1\tДа");
            System.out.println(".+\tНет");

            String operations = in.next();
            if (operations.trim().matches("1")) {
                service.sort();
            }
        } else System.out.println("Отсутствуют элементы, сортировка невозможна. Сначала загрузите элементы.");

    }
}