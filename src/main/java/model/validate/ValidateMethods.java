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
    public boolean busValidate(String classType, String number, String model, Integer mileage) {
        if (stringValidate(classType) && stringValidate(number) && stringValidate(model) && intValidate(mileage)){
        return true;}
        else return false;
    }

    @Override
    public boolean userValidate(String classType, String name, String pass, String email) {
        if (stringValidate(classType) && stringValidate(name) && stringValidate(pass) && stringValidate(email)){
            return true;}
        else return false;
    }

    @Override
    public boolean studentValidate(String classType, String group, Double gpa, Integer number) {
        if (stringValidate(classType) && stringValidate(group) && doubleValidate(gpa) && intValidate(number)){
            return true;}
        else return false;
    }

    @Override
    public boolean isInteger(String str) {
        return str.trim().matches("\\d{1,8}");
    }

    @Override
    public boolean isDouble(String str) {
        return str.trim().matches("\\d{1,2}[.]\\d{0,2}");
    }

    @Override
    public boolean isEmail(String str) {
        return str.trim().matches("\\w+[.-]?\\w+@\\w+[.][A-Za-z0-9]{2,3}");
    }

    @Override
    public boolean isWord(String str) {
        return str.matches("\\w+");
    }

    @Override
    public boolean isUser(String name, String pass, String email) {
        return isWord(name) && isWord(pass) && isEmail(email);
    }

    @Override
    public boolean isBus(String number, String model, String mileage) {
        return isWord(number) && isWord(model) && isInteger(mileage);
    }

    @Override
    public boolean isStudent(String group, String gpa, String number) {
        return isWord(group) && isDouble(gpa) && isInteger(number);
    }


    public static boolean isEmailValid(String str) {
        return str.matches("^[\\w-\\.]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$");
    }
    private boolean isWordValid(String str) {
        return str.matches("^[A-Za-z-0-9]*$");
    }
}
