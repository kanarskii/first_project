package ui;

import mobelLoadStrategy.StrategyType;
import model.impl.Model;
import model.impl.Student;

import java.util.List;

public interface UI {

    /**
     * Метод загрузки данных в программу
     * @see service.Service#loadModels(StrategyType)
     */
    void load();
    /**
     * Метод поиска данных в программе
     * @see service.Service
     */
    void search();
    /**
     * Помощь пользователю по меню программы
     */
    void help();
    /**
     * Отображение данных загруженных в программе
     * @see service.Service
     */
    void look();
    /**
     * закрытие ресурсов испоьзуемых классом
     */
    void close();

    void runner();
}
