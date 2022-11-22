package bridge.domain.PlayerMove;

public class PlayerMoveValidator {
    private static final String EMPTY_BRIDGE_MOVING_POSITION_ERROR_MESSAGE = "[ERROR] 이동할 칸이 입력되지 않았습니다.";
    private static final String MOVING_POSITION_LENGTH_OUT_OF_RANGE_ERROR_MESSAGE = "[ERROR] 이동할 칸은 문자 1글자만 입력되어야 합니다.";
    private static final String NOT_UP_AND_DOWN_CHARACTER_ERROR_MESSAGE = "[ERROR] 입력된 이동할 칸은 문자 U와 D가 아닙니다. U 또는 D만 입력해주세요.";

    private static final int MOVING_POSITION_LENGTH_LIMIT = 1;
    private static final String MOVING_POSITION_UP = "U";
    private static final String MOVING_POSITION_DOWN = "D";

    public static void validate(String movingPosition) {
        validateEmptyBridgeMovingPosition(movingPosition);

        validateMovingPositionLengthRange(movingPosition);

        validateNotUpAndDownCharacter(movingPosition);
    }

    public static void validateEmptyBridgeMovingPosition(String movingPosition) {
        if (movingPosition.isEmpty() || movingPosition == null) {
            throw new IllegalArgumentException(EMPTY_BRIDGE_MOVING_POSITION_ERROR_MESSAGE);
        }
    }

    public static void validateMovingPositionLengthRange(String movingPosition) {
        if (movingPosition.length() != MOVING_POSITION_LENGTH_LIMIT) {
            throw new IllegalArgumentException(MOVING_POSITION_LENGTH_OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public static void validateNotUpAndDownCharacter(String movingPosition) {
        if (!movingPosition.equals(MOVING_POSITION_UP) && !movingPosition.equals(MOVING_POSITION_DOWN)) {
            throw new IllegalArgumentException(NOT_UP_AND_DOWN_CHARACTER_ERROR_MESSAGE);
        }
    }
}