package bridge.utils;

public class Validator {
    public static String ERROR_BRIDGE_SIZE_NOT_INT = "[ERROR] 받은 다리 길이가 숫자가 아닙니다.";
    public static String ERROR_BRIDGE_SIZE_LOW = "[ERROR] 입력하는 다리 길이가 3 이상 20 이하의 숫자이어야 합니다.";

    public static void checkValueOfReadBridgeSize(Integer value) {
        if (isNumeric(value))
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_NOT_INT);
        if (value < 3 || value > 20)
            throw new IllegalArgumentException(ERROR_BRIDGE_SIZE_LOW);
    }

    public static boolean isNumeric(Integer s) {
        String value = Integer.toString(s);
        return value == null || !value.matches("[-+]?\\d*\\.?\\d+");
    }
}
