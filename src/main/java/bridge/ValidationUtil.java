package bridge;

import bridge.enums.ConstVariable;
import bridge.enums.InputKey;

public class ValidationUtil {

    public static void isValidBridgeLength(int value) {
        if (value < ConstVariable.MIN_BRIDGE_LENGTH.getValue()
                || value > ConstVariable.MAX_BRIDGE_LENGTH.getValue()) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public static void isUpOrDown(String input) {
        if (!input.equals(InputKey.U.getValue()) &&
                !input.equals(InputKey.D.getValue())) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력하셨습니다.");
        }
    }

    public static void isRetryOrQuit(String input) {
        if (!input.equals(InputKey.R.getValue()) &&
                !input.equals(InputKey.Q.getValue())) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값을 입력하셨습니다.");
        }
    }
}
