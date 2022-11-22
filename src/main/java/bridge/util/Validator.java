package bridge.util;

public class Validator {

    public static void validateBridgeSize(String bridgeSize) {
        checkNumber(bridgeSize);
        checkRange(bridgeSize);
    }

    public static void checkNumber(String bridgeSize) {
        try {
            int size = Integer.parseInt(bridgeSize);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
    }

    public static void checkRange(String bridgeSize) {
        int size = Integer.valueOf(bridgeSize);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 3이상 20이하의 숫자여야 합니다.");
        }
    }
}
