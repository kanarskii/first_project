import ui.UI;
import ui.UI_impl;

/**
 * Командный тестовый проект
 * @autor Евгений Канарский, Виктор Дробышевский, Илья Баренков, Игорь Абзалов, Игорь Кашолкин
 * @version 0.2
 */

public class Main {
    public static void main(String[] args) {
        UI ui = new UI_impl();

        ui.runner();
        ui.close();
    }
}
