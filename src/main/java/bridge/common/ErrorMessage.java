package bridge.common;

public class ErrorMessage {
    private static final String PREFIX = "[ERROR]";
    private static final String EMPTY = " ";
    private static final String INVALID_NUMBER = "다리 길이는 숫자여야 합니다.";
    private static final String INVALID_BRIDGE_SIZE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INVALID_MOVING = "이동할 칸은 U, D여야 합니다. (위: U, 아래: D)";
    private static final String INVALID_GAME_COMMAND = "게임 재시작/종료 여부는 R, D여야 합니다. (재시작: R, 종료: Q)";

    public static String isInvalidNumber() {
        return generate(INVALID_NUMBER);
    }

    public static String isInvalidBridgeSize() {
        return generate(INVALID_BRIDGE_SIZE);
    }

    public static String isInvalidMoving() {
        return generate(INVALID_MOVING);
    }

    public static String isInvalidGameCommand() {
        return generate(INVALID_GAME_COMMAND);
    }

    private static String generate(String message) {
        return PREFIX + EMPTY + message;
    }
}
