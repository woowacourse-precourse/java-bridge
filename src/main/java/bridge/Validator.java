package bridge;

import bridge.domain.Direction;

public class Validator {
    private static final int BRIDGE_SIZE_LOWER_INCLUSIVE = 3;
    private static final int BRIDGE_SIZE_UPPER_INCLUSIVE = 20;
    private static final String BRIDGE_SIZE_OUT_OF_RANGE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String INVALID_MOVING_ERROR = "[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자만 입력해야 합니다.";
    private static final String INVALID_GAME_COMMAND_ERROR = "[ERROR] R(재시작)과 Q(종료) 중 하나의 문자만 입력해야 합니다.";

    public static void validateMoving(String moving) {
        if (!moving.equals(Direction.Code.UP.getName()) && !moving.equals(Direction.Code.DOWN.getName())) {
            throw new IllegalArgumentException(INVALID_MOVING_ERROR);
        }
    }

    public static void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals("R") && !gameCommand.equals("Q")) {
            throw new IllegalArgumentException(INVALID_GAME_COMMAND_ERROR);
        }
    }

    public static void validateSize(int size) {
        if (size < BRIDGE_SIZE_LOWER_INCLUSIVE || size > BRIDGE_SIZE_UPPER_INCLUSIVE) {
            throw new IllegalArgumentException(BRIDGE_SIZE_OUT_OF_RANGE_ERROR);
        }
    }
}
