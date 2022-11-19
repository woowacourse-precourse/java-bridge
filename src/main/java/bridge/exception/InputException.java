package bridge.exception;

import java.util.regex.Pattern;

public class InputException {
    private static final Pattern MOVEMENT_DIRECTION = Pattern.compile("^(U)|(D)$");
    private static final Pattern RESTART_OR_QUIT = Pattern.compile("^(R)|(Q)$");
    private static final String INVALID_BRIDGE_SIZE_TYPE = "[ERROR] 다리의 길이는 숫자여야 합니다.";
    private static final String INVALID_BRIDGE_SIZE_RANGE = "[ERROR] 다리의 길이는 3 이상 20 이하여야 합니다.";
    private static final String INVALID_MOVEMENT_DIRECTION = "[ERROR] 이동할 칸은 U 또는 D 여야 합니다.";
    private static final String INVALID_RESTART_OR_QUIT_COMMAND = "[ERROR] 재시작 및 종료에 대한 입력은 R 또는 Q 여야 합니다.";
    private static final Integer MIN_BRIDGE_SIZE = 3;
    private static final Integer MAX_BRIDGE_SIZE = 20;

    public static void isValidBridgeSizeType(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_TYPE);
        }
    }

    public static void isValidBridgeSizeRange(String bridgeSize) {
        if (Integer.parseInt(bridgeSize) < MIN_BRIDGE_SIZE || Integer.parseInt(bridgeSize) > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(INVALID_BRIDGE_SIZE_RANGE);
        }
    }

    public static void isValidMovementDirection(String movementDirection) {
        if (!MOVEMENT_DIRECTION.matcher(movementDirection).matches()) {
            throw new IllegalArgumentException(INVALID_MOVEMENT_DIRECTION);
        }
    }

    public static void isValidRestartOrQuitCommand(String command) {
        if (!RESTART_OR_QUIT.matcher(command).matches()) {
            throw new IllegalArgumentException(INVALID_RESTART_OR_QUIT_COMMAND);
        }
    }
}
