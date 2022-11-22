package bridge.exception;

public class Exception {
    public void checkNumberRangeException(String number) {
        String REGEX = "^[3-9]{1}$|^1{1}[0-9]{1}$|^2{1}0{1}$";
        if (!number.matches(REGEX)) {
            throw new IllegalArgumentException();
        }
    }
}