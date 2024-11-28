package ui;

import java.util.Scanner;

public interface UI {
    /**
     * Запуск диалогового меню
     */
    void runner();
    /**
     * Остановка потока ввода
     * @see  Scanner#close()
     */
    void close();
}
