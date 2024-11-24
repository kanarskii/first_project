package model.validate;

public class ValidateMethods implements Validate{

    @Override
    public boolean validate(String str) {
        boolean result;

        if (str.contains("@")&& (str.contains("."))){
            result = isEmailValid(str);
        }
        else{
            result = isWordValid(str);
        }
        return result;
    }
    public static boolean isEmailValid(String str) {
        return str.matches("^[\\w-\\.]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$");
    }
    private boolean isWordValid(String str) {
        return str.matches("^[A-Za-z-]*$");
    }
}
