package bridge.view.input;

public class InputValidator {

    private static final int BRIDGE_LOWER_INCLUSIVE = 3;
    private static final int BRIDGE_UPPER_INCLUSIVE = 20;

    private InputValidator() {

    }

    public static void checkBridgeSizeOrElseThrowException(String bridgeSize) {
        if (!isNumber(bridgeSize) || !isInRange(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }


    private static boolean isNumber(String bridgeSize) {
        for (char i : bridgeSize.toCharArray()) {
            if (!Character.isDigit(i)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isInRange(int bridgeSize) {
        if (bridgeSize < BRIDGE_LOWER_INCLUSIVE || bridgeSize > BRIDGE_UPPER_INCLUSIVE) {
            return false;
        }

        return true;
    }

}
