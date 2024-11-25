import ui.UI;
import ui.UI_impl;

import java.util.Scanner;

/**
 * Командный тестовый проект
 * @autor Евгений Канарский, Виктор Дробышевский, Илья Баренков, Игорь Абзалов, Игорь Кашолкин
 * @version 0.2
 */

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
        System.out.println(user);*/
    }
}
