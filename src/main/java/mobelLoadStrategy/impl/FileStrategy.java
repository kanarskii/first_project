package mobelLoadStrategy.impl;

import mobelLoadStrategy.LoadStrategy;

import model.impl.Bus;
import model.impl.Model;
import model.impl.Student;
import model.impl.User;
import model.validate.ValidateMethods;

import java.util.ArrayList;
import java.util.List;


public class FileStrategy implements LoadStrategy{
    public String path;
    public List<Model> objectsList = new ArrayList<>();


            /**
             * Делаю коммент в ДжаваДокс первый раз
             * Метод считывает с файла преобразуя в Лист
             * Даллее проверяем на пустые строки и каждую строку через метод валидирующего класса прогоняем
             * по регулярному выражению
             * Далее возвращаем копию Листа
             *
             */

    @Override
    public List<Model> load(
            List<Model> objects  //vremenno podal list na vhod
    )  {

        try {
            // (FileInputStream fis = new FileInputStream(path);
            //    ObjectInputStream ois = new ObjectInputStream(fis)) {
            // List<Model> objects = (List<Model>) ois.readObject();

            for (Model o : objects) {
                boolean check1 = false;
                boolean check2 = false;
                boolean check3 = false;
                if (o instanceof Bus) {
                    try {
                        check1 = this.checkBusStrings((Bus) o);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else if (o instanceof Student) {
                    try {
                        check2 = this.checkStudentStrings((Student) o);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else if (o instanceof User) {
                    try {
                        check3 = this.checkUserStrings((User) o);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                // for (int i = 0; i < objects.size(); i++) {
                if (check1 || check2 || check3) {
                    objectsList.add(o);
                    System.out.println(o);
                }
                //}
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
            return objectsList;
        }
    //}

    boolean checkBusStrings(Bus data) throws Exception {
            final Integer mileage = data.getMileage();
            final String model = data.getModel();
            final String number = data.getNumber();
            boolean r1;
            boolean r2;
            boolean r3;
            boolean checkResult = false;
            ValidateMethods validate = new ValidateMethods();
            r1 = validate.intValidate(mileage);
                if (!r1) {
                throw new Exception("Поле mileage класса Bus" + mileage + "не прошло валидацию");
                }
            r2 = validate.stringValidate(model);
                if (!r2) {
                throw new Exception("Поле model класса Bus" + model + "не прошло валидацию");
                }
            r3 =  validate.stringValidate(number);
                if (!r3) {
                throw new Exception("Поле number класса Bus" + number + "не прошло валидацию");
                }
                if (r1 && r2 && r3) {
                    checkResult = true;
                }
            return checkResult;
    }
    boolean checkStudentStrings(Student data) throws Exception {
        final Integer number = data.getNumber();
        final String group = data.getGroup();
        final Double gpa = data.getGpa();
        boolean r1;
        boolean r2;
        boolean r3;
        boolean checkResult = false;
        ValidateMethods validate = new ValidateMethods();
        r1 = validate.intValidate(number);
        if (!r1) {
            throw new Exception("Поле mileage класса Student" + number + "не прошло валидацию");
        }
        r2 = validate.stringValidate(group);
        if (!r2) {
            throw new Exception("Поле model класса Student" + group + "не прошло валидацию");
        }
        r3 =  validate.doubleValidate(gpa);
        if (!r3) {
            throw new Exception("Поле number класса Student" + gpa + "не прошло валидацию");
        }
        if (r1 && r2 && r3) {
            checkResult = true;
        }
        return checkResult;
    }
    boolean checkUserStrings(User data) throws Exception {
        final String name = data.getName();
        final String email = data.getEmail();
        final String pass = data.getPass();
        boolean r1;
        boolean r2;
        boolean r3;
        boolean checkResult = false;
        ValidateMethods validate = new ValidateMethods();
        r1 = validate.stringValidate(name);
        if (!r1) {
            throw new Exception("Поле mileage класса Student" + name + "не прошло валидацию");
        }
        r2 = validate.stringValidate(email);
        if (!r2) {
            throw new Exception("Поле model класса Student" + email + "не прошло валидацию");
        }
        r3 =  validate.stringValidate(pass);
        if (!r3) {
            throw new Exception("Поле number класса Student" + pass + "не прошло валидацию");
        }
        if (r1 && r2 && r3) {
            checkResult = true;
        }
        return checkResult;
    }
}
