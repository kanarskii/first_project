package mobelLoadStrategy.impl;

import mobelLoadStrategy.LoadStrategy;

import model.ModelType;
import model.validate.ValidateMethods;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class FileStrategy implements LoadStrategy {
    public String path;
    public List<String> fromFileBusList = new ArrayList<>();
    public List<String> fromFileUserList = new ArrayList<>();
    public List<String> fromFileStudentList = new ArrayList<>();
    StringBuilder builder = new StringBuilder();


    /**
     * Делаю коммент в ДжаваДокс первый раз
     * Метод считывает с файла преобразуя в Лист
     * Даллее проверяем на пустые строки и каждую строку через метод валидирующего класса прогоняем
     * по регулярному выражению
     * Далее возвращаем копию Листа
     */

    @Override
    public List<String> load(ModelType type) {

        try (Scanner sc = new Scanner(new FileInputStream("in.csv"), "windows-1251")) {
            sc.nextLine();

            while (sc.hasNextLine()) {
                ValidateMethods validate = new ValidateMethods();
                String line = sc.nextLine();
                String[] splitLine = line.split(";");

                if (validate.stringValidate(splitLine[0])) {
                    if (splitLine[0].contains("bus")) {
                        final ModelType bus = type.BUS;
                        String classType = splitLine[0];
                        String number = splitLine[1];
                        String model = splitLine[2];
                        String stringMileage = splitLine[3];
                        int mileage = Integer.parseInt(stringMileage);
                        if (validate.busValidate(classType, number, model, mileage)) {
                            String validatedBusString = builder.append(classType).append(";").append(number).append(";").append(model).append(";").append(stringMileage).toString();
                            fromFileBusList.add(validatedBusString);
                        }
                    } else if (splitLine[0].contains("user")) {
                        final ModelType user = type.USER;
                        String classType = splitLine[0];
                        String name = splitLine[1];
                        String pass = splitLine[2];
                        String email = splitLine[3];
                        if (validate.userValidate(classType, name, pass, email)) {
                            String validatedUserString = builder.append(classType).append(";").append(name).append(";").append(pass).append(";").append(email).toString();
                            fromFileBusList.add(validatedUserString);
                        }
                    } else if (splitLine[0].contains("student")) {
                        final ModelType student = type.STUDENT;
                        String classType = splitLine[0];
                        String group = splitLine[1];
                        String stringGpa = splitLine[2];
                        double gpa = Double.parseDouble(stringGpa);
                        String stringNumber = splitLine[3];
                        int number = Integer.parseInt(stringNumber);
                        if (validate.studentValidate(classType, group, gpa, number)) {
                            String validatedBusString = builder.append(classType).append(";").append(group).append(";").append(stringGpa).append(";").append(stringNumber).toString();
                            fromFileBusList.add(validatedBusString);
                        }
                    }
                }
            }
            switch (type) {
                case USER -> {
                    return fromFileUserList;
                }
                case BUS -> {
                    return fromFileBusList;
                }
                case STUDENT -> {
                    return fromFileStudentList;
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("csv file is not found");
        }
        return null;
    }
}




