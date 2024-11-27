package model.validate;

public interface Validate {

    boolean stringValidate(String str);

    boolean intValidate(Integer number);

    boolean doubleValidate(Double gpa);

    boolean busValidate(String classType, String number,String model, Integer mileage);
    boolean userValidate(String classType, String name,String pass, String email);
    boolean studentValidate(String classType, String group,Double gpa, Integer number);
}
