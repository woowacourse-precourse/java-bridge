package bridge.view.input;

import bridge.status.Bridge;
import bridge.status.Direction;
import bridge.status.Retry;

public class InputValidator {

    private InputValidator() {

    }

    public static void checkBridgeSizeOrElseThrowException(String bridgeSize) {
        if (!isNumber(bridgeSize) || !Bridge.isInRange(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void checkDirectionOrElseThrowException(String direction) {
        if (!Direction.contains(direction)) {
            throw new IllegalArgumentException("방향 입력은 U 또는 D만 허용됩니다.");
        }

    }

    public static void checkRetryOrElseThrowException(String retryCommand) {
        if (!Retry.contains(retryCommand)) {
            throw new IllegalArgumentException("재시작 입력은 R 또는 Q만 허용됩니다.");
        }
    }


    private static boolean isNumber(String bridgeSize) {
        if (bridgeSize == null || bridgeSize.equals("")) {
            return false;
        }
        for (char i : bridgeSize.toCharArray()) {
            if (!Character.isDigit(i)) {
                return false;
            }
        }

        return true;
    }


}
