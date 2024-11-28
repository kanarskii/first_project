package mobelLoadStrategy.impl;

import mobelLoadStrategy.LoadStrategy;

import model.ModelType;

import java.io.*;
import java.util.*;


public class FileStrategy implements LoadStrategy {
    public String path;
    public List<String> fromFileList = new ArrayList<>();

    StringBuilder builder;

    /**
     *
     * Метод считывает с файла преобразуя в Лист
     * Даллее проверяем на пустые строки и каждую строку через метод валидирующего класса прогоняем
     * по регулярному выражению
     * Далее возвращаем копию Листа
     */

    @Override
    public List<String> load(ModelType type) {
        List<String> list = new ArrayList<>();

        switch (type){
            case USER -> path = "user.csv";
            case BUS -> path = "bus.csv";
            case STUDENT -> path = "student.csv";
        }

        try (Scanner sc = new Scanner(new FileInputStream(path), "windows-1251")) {
            while (sc.hasNextLine()) {
                builder = new StringBuilder();
                list.add(sc.nextLine());
            }
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return list;
    }
}




