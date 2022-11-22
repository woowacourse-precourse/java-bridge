package bridge.validator;

public class BridgeSizeValidator {
    public static final int BRIDGE_SIZE_LOWER = 3;
    public static final int BRIDGE_SIZE_UPPER = 20;
    public static boolean isRange(String input){
        int size = Integer.parseInt(input);
        if (size < BRIDGE_SIZE_LOWER) {
            return false;
        }
        if (size > BRIDGE_SIZE_UPPER) {
            return false;
        }
        return true;
    }

    public static boolean isDigit(String input) {
        if (Character.isDigit(input.charAt(0))) {
            return true;
        }
        return false;
    }
    public static void validateBridgeSize(String input) {
        if (!isDigit(input)) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        if (!isRange(input)) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
