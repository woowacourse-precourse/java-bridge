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
    public static void validateBridgeSize(String input) {
        if (!isRange(input)) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
