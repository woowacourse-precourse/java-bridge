package bridge.utils;

public class Validator {
    public static void isDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }
}
