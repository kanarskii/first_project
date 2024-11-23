import model.impl.Model;
import model.impl.User;

import java.util.ArrayList;
import java.util.List;

import static service.Sort.quickSort;


public class Main {
    public static void main(String[] args) {


//        Bus bus = Bus.builder().mileage(10).model("model").number("2058-qwe").build();
//        System.out.println(bus);
//        Student student = Student.builder().gpa(7.5).group("AZ-00").number(15282).build();
//        System.out.println(student);
        User user = User.builder().email("a@mail.com").name("Login").pass("qwerty12345").build();
//        System.out.println(user);

        List<Model> list = new ArrayList<>();
        list.add(user);
        list.add(new User("Ken", "12321", "1231@gmail.com"));

        list.add(new User("Tom", "12321", "1231@gmail.com"));
        list.add(new User("Bob", "12321", "1231@gmail.com"));
        list.add(new User("Adam", "12321", "1231@gmail.com"));
        list.add(new User("Jack", "12321", "1231@gmail.com"));

        System.out.println(list);

        quickSort(list, 0,(list.size() - 1));

        System.out.println(list);
    }
}
