package bridge;

public class ValidationUtil {

    public static boolean isValidBridgeLength(int value) {
        return value >= ConstVariable.MIN_BRIDGE_LENGTH.getValue()
                && value <= ConstVariable.MAX_BRIDGE_LENGTH.getValue();
    }
}
