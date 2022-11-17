package bridge.utils;

public class Validator {
    public static void checkIsNumber(String number) {
        String numberRegularExpression = "^[0-9]+$";
        boolean isNotNumber = !number.matches(numberRegularExpression);
        if (isNotNumber) {
            throw new IllegalArgumentException("다리 길이는 숫자입니다.");
        }
    }
}
