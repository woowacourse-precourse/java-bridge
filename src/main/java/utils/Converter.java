package utils;

public class Converter {
    private static final int ZERO = 0;
    private static final String UPPER_BRIDGE = "U";
    private static final String LOWER_BRIDGE = "D";

    public static String convertNumberToBridgeUpOrDown(int randomNumber) {
        if (randomNumber == ZERO) {
            return LOWER_BRIDGE;
        }
        return UPPER_BRIDGE;
    }
}
