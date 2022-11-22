package bridge.util.validator;

import java.util.regex.Pattern;

public class InputValidator {
    private static final int BRIDGE_SIZE_MIN = 3;
    private static final int BRIDGE_SIZE_MAX = 20;

    public static void validateBridgeSize(String input) throws IllegalArgumentException {
        String condition = "^[0-9]+$";
        if (!Pattern.matches(condition, input)) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3에서 20 사이의 정수입니다.");
        }
        int bridgeSize = Integer.parseInt(input);
        if ((bridgeSize < BRIDGE_SIZE_MIN) || (bridgeSize > BRIDGE_SIZE_MAX)) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3에서 20 사이의 정수입니다.");
        }
    }

    public static void validateMoving(String input) throws IllegalArgumentException {
        String condition = "^[UD]{1}$";
        if (!Pattern.matches(condition, input)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 공백없이 'U' 또는 'D' 이어야 합니다.");
        }
    }

    public static void validateGameCommand(String input) throws IllegalArgumentException {
        String condition = "^[RQ]{1}$";
        if (!Pattern.matches(condition, input)) {
            throw new IllegalArgumentException("[ERROR] 재시작 여부는 'R' 또는 'Q' 이어야 합니다.");
        }
    }
}
