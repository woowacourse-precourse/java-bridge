package bridge;

public class Validator {
    public static Integer validatedBridgeSize(String input) throws IllegalArgumentException {
        Integer bridgeSize;
        try {
            bridgeSize = isNumber(input);
            isLargerOrEqual(Constant.MIN_BRIDGE_SIZE, bridgeSize);
            isSmallerOrEqual(Constant.MAX_BRIDGE_SIZE, bridgeSize);
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(Constant.BRIDGE_SIZE_ERROR);
        }
    }

    public static Integer isNumber(String input) {
        try {
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void isLargerOrEqual(Integer min, Integer input) {
        if (input < min) {
            throw new IllegalArgumentException();
        }
    }

    public static void isSmallerOrEqual(Integer max, Integer input) {
        if (input > max) {
            throw new IllegalArgumentException();
        }
    }
}
