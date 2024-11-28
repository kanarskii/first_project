import mobelLoadStrategy.impl.FileStrategy;
import model.ModelType;
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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //UI ui = new UI_impl();

        //ui.runner();
        //ui.close();
        FileStrategy strategy = new FileStrategy();

        strategy.load(ModelType.BUS);
        System.out.println(strategy.fromFileList);
        //strategy.load(ModelType.USER);
        //System.out.println(strategy.fromFileUserList);

/*        Bus bus = Bus.builder().mileage(10).model("model").number("2058-qwe").build();
        System.out.println(bus);
        Student student =Student.builder().gpa(7.5).group("AZ-00").number(15282).build();
        System.out.println(student);
        User user = User.builder().email("a@mail.com").name("Login").pass("qwerty12345").build();
        System.out.println(user);*/

        List<Model> studentList = new ArrayList<>();
        studentList.add(Student.builder().gpa(7.5).group("AZ").number(15282).build());
        studentList.add(Student.builder().gpa(7.5).group("AZ").number(15283).build());
        studentList.add(Student.builder().gpa(7.5).group("AZ").number(15292).build());
        studentList.add(Student.builder().gpa(7.5).group("AZ").number(15382).build());
        studentList.add(Student.builder().gpa(7.5).group("AZ").number(15782).build());

        List<Model> userList = new ArrayList<>();
        userList.add(User.builder().pass("yuyu").name("uiui").email("ert@mail.ru").build());

        List<Model> busList = new ArrayList<>();
        busList.add(Bus.builder().mileage(23).model("iuiu").number("454UF").build());


        //strategy.load(busList);
        //strategy.load(studentList);
        //strategy.load(userList);
        //System.out.println(strategy.objectsList);


        //Student students = Student.builder().gpa(7.5).group("AZ-00").number(3).build();
        //System.out.println(Search.binarySearch(studentList,students, Comparator.comparingInt(Student::getNumber)));
        //students = studentList.get(3);
        //System.out.println(Search.binarySearch(studentList,students, Comparator.comparingInt(Student::getNumber)));
        //System.out.println(user);
    }
}
