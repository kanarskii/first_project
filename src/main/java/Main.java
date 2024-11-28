import ui.UI;
import ui.UI_impl;

/**
 * Командный тестовый проект Aston 11.2024
 * @autor Евгений Канарский, Виктор Дробышевский, Илья Баренков, Игорь Абзалов, Игорь Кашолкин
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        UI ui = new UI_impl();

        ui.runner();
        ui.close();
    }
}
