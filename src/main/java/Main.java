import model.impl.Bus;
import model.impl.Student;
import model.impl.User;

public class Main {
    public static void main(String[] args) {


        Bus bus = Bus.builder().mileage(10).model("model").number("2058-qwe").build();
        System.out.println(bus);
        Student student =Student.builder().gpa(7.5).group("AZ-00").number(15282).build();
        System.out.println(student);
        User user = User.builder().email("a@mail.com").name("Login").pass("qwerty12345").build();
        System.out.println(user);
    }
}
