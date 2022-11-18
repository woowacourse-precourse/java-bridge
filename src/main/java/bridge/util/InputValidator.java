package bridge.util;

public class InputValidator {

    public static void validateBridgeSize(String bridgeSize) {
        if (!isNumber(bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER);
        }

        if (!isRangeSize(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_RANGE_SIZE);
        }
    }

    public static boolean isNumber(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    public static boolean isRangeSize(int number) {
        return BridgeConstatns.SIZE_MINIMUM <= number && number <= BridgeConstatns.SIZE_MAXIMUM;
    }
}
