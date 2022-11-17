package bridge.validator;

public class InputValidator {

    private static final String BRIDGE_SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    public static int validateBridgeSize(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
        if (!isSizeThreeToTwenty(input)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
        return Integer.parseInt(input);
    }

    private static boolean isNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    private static boolean isSizeThreeToTwenty(String input) {
        int bridgeSize = Integer.parseInt(input);
        return bridgeSize >= 3 && bridgeSize <= 20;
    }
}
