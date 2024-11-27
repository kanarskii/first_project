import mobelLoadStrategy.impl.FileStrategy;
import model.Model;
import model.ModelType;
import model.impl.Bus;
import model.impl.Student;
import model.impl.User;
import service.Search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static service.Sort.quickSort;

public class TestMain {
    public static void main(String[] args) {

/*        List<Model> list = new ArrayList<>();
        Student student = Student.builder().gpa(7.5).group("AZ-00").number(15282).build();
        list.add(student);
        list.add(new Student("Sqew", 1.0, 3));
        list.add(new Student("Da", 1.0, 3));
        list.add(new Student("Sqq", 1.0, 3));
        list.add(new Student("ADC", 1.0, 3));
        list.add(new Student("ZXV", 1.0, 3));



        Bus bus = Bus.builder().mileage(10).model("model").number("2058-qwe").build();
        System.out.println(bus);
        System.out.println(student);

        User user = User.builder().email("a@mail.com").name("Login").pass("qwerty12345").build();
        System.out.println(user);
        */

        List<Model> studentList = new ArrayList<>();
        studentList.add(Student.builder().gpa(7.5).group("AZ-00").number(1).build());
        studentList.add(Student.builder().gpa(7.5).group("AZ-00").number(2).build());
        studentList.add(Student.builder().gpa(7.5).group("AZ-00").number(3).build());
        studentList.add(Student.builder().gpa(7.5).group("AZ-00").number(15382).build());
        studentList.add(Student.builder().gpa(7.5).group("AZ-00").number(30).build());

        Student students = Student.builder().gpa(null).group(null).number(3).build();

       // System.out.println(Search.binarySearch(studentList,students, Comparator.comparingInt(Student::getNumber)));


        System.out.println(students);
        int i = Search.binarySearch(studentList, students, Comparator.comparingInt(Student::getNumber));
        System.out.println(i);

        System.out.println(studentList.get(i));

        System.out.println();

        System.out.println(" массив по которому был поиск ");

        studentList.forEach(System.out::println);


       /* System.out.println(user);

        list.add(user);
        list.add(new User("Tom", "12321", "1231@gmail.com"));
        list.add(new User("Bob", "12321", "1231@gmail.com"));
        list.add(new User("Jack", "12321", "1231@gmail.com"));
        list.add(new User("Ken", "12321", "1231@gmail.com"));
        list.add(new User("Adam", "12321", "1231@gmail.com"));

        System.out.println(list);

        quickSort(list, 0, (list.size() - 1));

        System.out.println(list);*/
        /*
        throws IOException, ClassNotFoundException {
            //UI ui = new UI_impl();

            //ui.runner();
            //ui.close();
            FileStrategy strategy = new FileStrategy();

            //strategy.load(ModelType.BUS);
            //System.out.println(strategy.fromFileBusList);
            strategy.load(ModelType.USER);
            System.out.println(strategy.fromFileUserList);

        Bus bus = Bus.builder().mileage(10).model("model").number("2058-qwe").build();
        System.out.println(bus);
        Student student =Student.builder().gpa(7.5).group("AZ-00").number(15282).build();
        System.out.println(student);
        User user = User.builder().email("a@mail.com").name("Login").pass("qwerty12345").build();
        System.out.println(user);

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

*/
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
