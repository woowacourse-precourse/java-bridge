package bridge.exception;

public class InputException {
    static final String NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";
    static final String BRIDGE_SIZE_RANGE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    static final String MOVING_ERROR_MESSAGE = "[ERROR] U(위 칸) 또는 D(아래 칸) 중 하나를 입력해주세요.";
    static final String GAME_COMMAND_ERROR_MESSAGE = "[ERROR] R(게임 재시작) 또는 Q(게임 종료) 중 하나를 입력해주세요.";
    static final String MOVING_UP = "U";
    static final String MOVING_DOWN = "D";
    static final String GAME_RESTART = "R";
    static final String GAME_QUIT = "Q";
    static final int MIN_BRIDGE_SIZE = 3;
    static final int MAX_BRIDGE_SIZE = 20;

    public static void checkIsBridgeSizeInteger(String bridgeSize) {
        if (!bridgeSize.matches("-?\\d+(\\.\\d+)?")) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    public static void checkBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_RANGE_ERROR_MESSAGE);
        }
    }

    public static void checkMoving(String moving) {
        if (!moving.equals(MOVING_UP) && !moving.equals(MOVING_DOWN)) {
            throw new IllegalArgumentException(MOVING_ERROR_MESSAGE);
        }
    }

    public static void checkGameCommand(String gameCommand) {
        if (!gameCommand.equals(GAME_RESTART) && !gameCommand.equals(GAME_QUIT)) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR_MESSAGE);
        }
    }
}