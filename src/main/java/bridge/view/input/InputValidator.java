package bridge.view.input;

import bridge.command.Bridge;

public class InputValidator {

    private InputValidator() {

    }

    public static void checkBridgeSizeOrElseThrowException(String bridgeSize) {
        if (!isNumber(bridgeSize) || !Bridge.isInRange(Integer.parseInt(bridgeSize))) {
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


}
