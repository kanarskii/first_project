package ui;

import mobelLoadStrategy.ServiceLoadModel;
import mobelLoadStrategy.StrategyType;
import model.Model;
import model.ModelType;
import model.impl.Bus;
import model.impl.Student;
import model.impl.User;
import model.validate.ValidateMethods;
import service.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Класс реализация пользовательского интерфейса.
 * @autor Виктор Дробышевский
 * @version 1.0
 */

public class UI_impl implements UI{

    private final Service service = new Service();
    private final ServiceLoadModel loader = new ServiceLoadModel();
    private final Scanner in = new Scanner(System.in);
    private final ValidateMethods validate = new ValidateMethods();
    private ModelType type;
    private Comparator comparator;

    @Override
    public void runner() {
        String operations;
        boolean work = true;
        System.out.println("Добро пожаловать.");
        modelType();

        while (work) {
            menu();
            operations = in.next();
            if (operations.trim().matches("[1-5]")) {
                switch (operations) {
                    case "1" -> load();
                    case "2" -> look();
                    case "3" -> sorting();
                    case "4" -> search();
                    case "5" -> work = false;
                }
            } else
                System.out.println("Введена неподдерживаемая команда.");
        }
    }

    @Override
    public void close() {
        in.close();
    }

    private void load() {
        List<Model> models = List.of();
        System.out.println("Процесс загрузки элементов");

        System.out.println("1\tЗагрузка из файла");
        System.out.println("2\tВвод из консоли");
        System.out.println("3\tЗаполнение N случайными элементами");
        System.out.println("+\t для возврата в главное меню");

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
                Model model =null;
                Model search = null;
                String searchModel;

                switch (type) {
                    case BUS: {
                        System.out.println("Для поиска автобуса необходимо указать его номер который может содержать:");
                        System.out.println("Буквы и цифры, а также нижнее подчеркивание");
                        searchModel = in.next();
                        if (!validate.isWord(searchModel)) {
                            System.out.println("Введено некорректное значение. Возврат в главное меню");
                            return;
                        }
                        model = Bus.builder().number(searchModel).build();
                        break;
                    }
                    case USER: {
                        System.out.println("Для поиска пользователя необходимо указать его имя в соответствии с форматом:");
                        System.out.println("Буквы и цифры, а также нижнее подчеркивание");
                        searchModel = in.next();
                        if (!validate.isWord(searchModel)) {
                            System.out.println("Введено некорректное значение. Возврат в главное меню");
                            return;
                        }
                        model = User.builder().name(searchModel).build();
                        break;
                    }
                    case STUDENT: {
                        System.out.println("Для поиска студента необходимо указать его номер зачетной книжки в соответствии с форматом:");
                        System.out.println("Положительное число не более 10^8");
                        searchModel = in.next();
                        if (!validate.isInteger(searchModel)) {
                            System.out.println("Введено некорректное значение. Возврат в главное меню");
                            return;
                        }
                        model = Student.builder().number(Integer.parseInt(searchModel)).build();
                        break;
                    }
                }

                search = service.searchModel(model, comparator);

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
        System.out.println("5\tВыход");
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
            System.out.println("Выберете модель для дальнейшей работы:");
            System.out.println("1\tАвтобус");
            System.out.println("2\tПользователь");
            System.out.println("3\tСтудент");

            String operations = in.next();

            if (operations.trim().matches("[1-3]")) {
                switch (operations) {
                    case "1" -> {
                        type = ModelType.BUS;
                        comparator = Comparator.comparing(Bus::getNumber);
                    }
                    case "2" -> {
                        type = ModelType.USER;
                        comparator = Comparator.comparing(User::getName);
                    }
                    case "3" -> {
                        type = ModelType.STUDENT;
                        comparator = Comparator.comparingInt(Student::getNumber);
                    }
                }
                service.setModels(new ArrayList<>());
            }
        }
    }

    private void sorting() {
        if (service.empty()) {
            System.out.println("Выполнить сортировку элементов");
            System.out.println("1\tВыполнить быструю сортировку");
            System.out.println("2\tВыполнить натуральную сортировку (Доп)");
            System.out.println(".+\tНе выполнять");
            System.out.println("После выполнения натуральной сортировки коллекция считается не отсортированной!");

            String operations = in.next();
            if (operations.trim().matches("1")) {
                service.quickSorting(comparator);
            }
            if (operations.trim().matches("2")) {
                service.naturalSorting(comparator);
            }

            look();
        } else System.out.println("Отсутствуют элементы, сортировка невозможна. Сначала загрузите элементы.");

    }
}