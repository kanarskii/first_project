package mobelLoadStrategy.impl;

import mobelLoadStrategy.LoadStrategy;

import model.ModelType;
import model.validate.ValidateMethods;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

        switch (type){
            case USER -> path = "user.csv";
            case BUS -> path = "bus.csv";
            case STUDENT -> path = "student.csv";
        }

        try (Scanner sc = new Scanner(new FileInputStream("in.csv"), "windows-1251")) {
            while (sc.hasNextLine()) {
                ValidateMethods validate = new ValidateMethods();
                builder = new StringBuilder();
                String line = sc.nextLine();
                String[] splitLine = line.split(";");
                String validatedBusString;
        //if (validate.stringValidate(splitLine[0])) {
        if (type == ModelType.BUS) {
            String classType = splitLine[0];
            String number = splitLine[1];
            String model = splitLine[2];
            String stringMileage = splitLine[3];
            //int mileage = Integer.parseInt(stringMileage);
            // if (validate.busValidate(classType, number, model, mileage)) {
            validatedBusString = builder.append(number).append(";").append(model).append(";").append(stringMileage).toString();
            // }
            fromFileList.add(validatedBusString);
        }
        if (type == ModelType.USER) {

            String name = splitLine[1];
            String pass = splitLine[2];
            String email = splitLine[3];
            if (validate.userValidate(name, pass, email)) {
                String validatedUserString = builder.append(name).append(";").append(pass).append(";").append(email).toString();
                fromFileList.add(validatedUserString);
            }
        }
        if (type == ModelType.STUDENT) {
            String group = splitLine[1];
            String stringGpa = splitLine[2];
            double gpa = Double.parseDouble(stringGpa);
            String stringNumber = splitLine[3];
            int number = Integer.parseInt(stringNumber);
            if (validate.studentValidate(group, gpa, number)) {
                String validatedStudentString = builder.append(group).append(";").append(stringGpa).append(";").append(stringNumber).toString();
                fromFileList.add(validatedStudentString);
            }
        }
    }
} catch (Exception ex) {
           ex.printStackTrace();
        }
        return null;
    }
}




