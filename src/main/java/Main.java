import ui.UI;
import ui.UI_impl;

import java.util.Scanner;

/**
 * Командный тестовый проект
 * @autor Евгений Канарский, Виктор Дробышевский, Илья Баренков, Игорь Абзалов, Игорь Кашолкин
 * @version 0.2
 */
import model.Model;
import model.impl.Bus;
import model.impl.Student;
import model.impl.User;
import service.Search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String operations = "";
        UI ui = new UI_impl();
        boolean work = true;
        System.out.println("Добро пожаловать.");
        ui.help();

        while (work) {
            operations = in.next();
            if (operations.trim().matches("\\d")) {
                int op = Integer.parseInt(operations);
                switch (op) {
                    case 1:
                        ui.load();
                        break;
                    case 2:
                        ui.look();
                        break;
                    case 3:
                        ui.search();
                        break;
                    case 4:
                        ui.help();
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
        ui.close();
        in.close();


/*        Bus bus = Bus.builder().mileage(10).model("model").number("2058-qwe").build();
        System.out.println(bus);
        Student student =Student.builder().gpa(7.5).group("AZ-00").number(15282).build();
        System.out.println(student);
        User user = User.builder().email("a@mail.com").name("Login").pass("qwerty12345").build();
        System.out.println(user);
        List<Student> studentList = new ArrayList<>();
        studentList.add(Student.builder().gpa(7.5).group("AZ-00").number(15282).build());
        studentList.add(Student.builder().gpa(7.5).group("AZ-00").number(15283).build());
        studentList.add(Student.builder().gpa(7.5).group("AZ-00").number(15292).build());
        studentList.add(Student.builder().gpa(7.5).group("AZ-00").number(15382).build());
        studentList.add(Student.builder().gpa(7.5).group("AZ-00").number(15782).build());
        Student students = Student.builder().gpa(7.5).group("AZ-00").number(3).build();
        System.out.println(Search.binarySearch(studentList,students, Comparator.comparingInt(Student::getNumber)));
        students = studentList.get(3);
        System.out.println(Search.binarySearch(studentList,students, Comparator.comparingInt(Student::getNumber)));
        System.out.println(user);*/
    }
}
