package model.validate;

public class ValidateMethods implements Validate{

    @Override
    public boolean stringValidate(String str) {
        boolean result;

        if (str.contains("@")&& (str.contains("."))){
            result = isEmailValid(str);
        }
        else{
            result = isWordValid(str);
        }
        return result;
    }

    @Override
    public boolean intValidate(Integer number) {
        if (number < 0) {
            return false;
        }
        else return true;
    }

    @Override
    public boolean doubleValidate(Double doubl) {
        if (doubl < 0) {
            return false;
        }
        else return true;
    }

    @Override
    public boolean busValidate(String number, String model, Integer mileage) {
        if (stringValidate(number) && stringValidate(model) && intValidate(mileage)){
        return true;}
        else return false;
    }

    @Override
    public boolean userValidate(String name, String pass, String email) {
        if (stringValidate(name) && stringValidate(pass) && stringValidate(email)){
            return true;}
        else return false;
    }

    @Override
    public boolean studentValidate(String group, Double gpa, Integer number) {
        if (stringValidate(group) && doubleValidate(gpa) && intValidate(number)){
            return true;}
        else return false;
    }

    public static boolean isEmailValid(String str) {
        return str.matches("^[\\w-\\.]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$");
    }
    private boolean isWordValid(String str) {
        return str.matches("^[A-Za-z-0-9]*$");
    }
}
