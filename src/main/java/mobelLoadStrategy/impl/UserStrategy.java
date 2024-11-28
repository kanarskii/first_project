package mobelLoadStrategy.impl;
import mobelLoadStrategy.LoadStrategy;
import model.ModelType;
import model.validate.ValidateMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserStrategy implements LoadStrategy {

    private final ValidateMethods validate = new ValidateMethods();

    @Override
    public List<String> load(ModelType type) {
        List<String> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Сколько вы хотите создать? ");
        String count = in.next();
        int iteration;
        if (count.trim().matches("\\d+")) {

            StringBuilder sb;

            iteration = Integer.parseInt(count);

            for (int i = 0; i < iteration; i++) {

                sb = new StringBuilder();

                switch (type) {
                    case USER -> {
                        while (true) {
                            System.out.println("Введите имя");
                            String name = in.next();
                            if (validate.isWord(name)) {
                                sb.append(name).append(";");
                                break;
                            }
                            System.out.println("Значение введене не корректно, повторите ввод");

                        }
                        while (true) {
                            System.out.println("Введите пароль");
                            String password = in.next();
                            if (validate.isWord(password)) {
                                sb.append(password).append(";");
                                break;
                            }
                            System.out.println("Значение введене не корректно, повторите ввод");
                        }
                        while (true) {
                            System.out.println("Введите email");
                            String email = in.next();
                            if (validate.isEmail(email)) {
                                sb.append(email).append(";");
                                break;
                            }
                            System.out.println("Значение введене не корректно, повторите ввод");
                        }
                        list.add(sb.toString());
                    }

                    case STUDENT -> {
                        while (true) {
                            System.out.println("Введите группу студента");
                            String group = in.next();
                            if (validate.isWord(group)) {
                                sb.append(group).append(";");
                                break;
                            }
                            System.out.println("Значение введене не корректно, повторите ввод");

                        }
                        while (true) {
                            System.out.println("Введите средний балл студента");
                            String gpa = in.next();
                            if (validate.isDouble(gpa)) {
                                sb.append(gpa).append(";");
                                break;
                            }
                            System.out.println("Значение введене не корректно, повторите ввод");
                        }
                        while (true) {
                            System.out.println("Введите номер зачетки студента");
                            String number = in.next();
                            if (validate.isInteger(number)) {
                                sb.append(number).append(";");
                                break;
                            }
                            System.out.println("Значение введене не корректно, повторите ввод");
                        }
                        list.add(sb.toString());
                    }
                    case BUS -> {
                        while (true) {
                            System.out.println("Введите номер автобуса");
                            String number = in.next();
                            if (validate.isWord(number)) {
                                sb.append(number).append(";");
                                break;
                            }
                            System.out.println("Значение введене не корректно, повторите ввод");

                        }
                        while (true) {
                            System.out.println("Введите модель автобуса");
                            String model = in.next();
                            if (validate.isWord(model)) {
                                sb.append(model).append(";");
                                break;
                            }
                            System.out.println("Значение введене не корректно, повторите ввод");
                        }
                        while (true) {
                            System.out.println("Введите пробег автобуса");
                            String mileage = in.next();
                            if (validate.isInteger(mileage)) {
                                sb.append(mileage).append(";");
                                break;
                            }
                            System.out.println("Значение введене не корректно, повторите ввод");
                        }
                        list.add(sb.toString());
                    }
                }
            }
        } else {
            System.out.println("Введено некорректное значение");
        }

        return list;
    }
}
