package ui;

import mobelLoadStrategy.StrategyType;

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
