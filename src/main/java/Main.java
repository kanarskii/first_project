import ui.UI;
import ui.UI_impl;

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

import java.util.ArrayList;
import java.util.List;

import static service.Sort.quickSort;


public class Main {
    public static void main(String[] args) {
        UI ui = new UI_impl();

        ui.runner();
        ui.close();
        List<Model> list = new ArrayList<>();
//        Student student = Student.builder().gpa(7.5).group("AZ-00").number(15282).build();
//        list.add(student);
//        list.add(new Student("Sqew", 1.0, 3));
//        list.add(new Student("Da", 1.0, 3));
//        list.add(new Student("Sqq", 1.0, 3));
//        list.add(new Student("ADC", 1.0, 3));
//        list.add(new Student("ZXV", 1.0, 3));



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
        list.add(user);
        list.add(new User("Tom", "12321", "1231@gmail.com"));
        list.add(new User("Bob", "12321", "1231@gmail.com"));
        list.add(new User("Jack", "12321", "1231@gmail.com"));
        list.add(new User("Ken", "12321", "1231@gmail.com"));
        list.add(new User("Adam", "12321", "1231@gmail.com"));

        System.out.println(list);

        quickSort(list, 0, (list.size() - 1));

        System.out.println(list);
    }
}
