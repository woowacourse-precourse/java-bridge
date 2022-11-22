package bridge.common;

public class ErrorMessage {
    private static final String PREFIX = "[ERROR]";
    private static final String EMPTY = " ";
    private static final String INVALID_NUMBER = "다리 길이는 숫자여야 합니다.";
    private static final String INVALID_BRIDGE_SIZE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INVALID_MOVING_COMMAND = "이동할 칸은 U, D여야 합니다. (위: U, 아래: D)";
    private static final String INVALID_GAME_STATUS_COMMAND = "게임 재시작/종료 여부는 R, Q여야 합니다. (재시작: R, 종료: Q)";
    private static final String INVALID_ROUND_RANGE = "허용된 라운드 범위를 벗어났습니다.";
    private static final String INVALID_GAME_STATUS = "다리 건너기 게임을 진행할 수 없습니다.";

    public static String isInvalidNumber() {
        return generate(INVALID_NUMBER);
    }

    public static String isInvalidBridgeSize() {
        return generate(INVALID_BRIDGE_SIZE);
    }

    public static String isInvalidMovingCommand() {
        return generate(INVALID_MOVING_COMMAND);
    }

    public static String isInvalidGameStatusCommand() {
        return generate(INVALID_GAME_STATUS_COMMAND);
    }

    public static String isInvalidRoundRange() {
        return generate(INVALID_ROUND_RANGE);
    }

    public static String isInvalidGameStatus() {
        return generate(INVALID_GAME_STATUS);
    }

    private static String generate(String message) {
        return PREFIX + EMPTY + message;
    }
}
