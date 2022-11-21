package bridge.util;

public class InputValidator {

    public static void validateNumber(String bridgeSize) {
        if (!isNumber(bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER);
        }
    }

    public static boolean isNumber(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

}
