package bridge.validator;

public class Validator {

    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;
    public static final String MOVE_UP = "U";
    public static final String MOVE_DOWN = "D";
    public static final String GAME_RESTART_COMMAND = "R";
    public static final String GAME_QUIT_COMMAND = "Q";
    private static final String OUT_OF_BOUNDS_SIZE_ERROR_MESSAGE = "[ERROR] 범위를 벗어난 길이입니다.";
    private static final String MOVING_INPUT_ERROR_MESSAGE = "[ERROR] 이동은 U(위)/D(아래)로만 할 수 있습니다.";
    private static final String GAME_COMMAND_ERROR_MESSAGE = "[ERROR] 명령은 R(재시작)/Q(종료)로만 할 수 있습니다.";

    public static boolean isValidBridgeSize(int input) {
        if (!(input >= MIN_BRIDGE_SIZE && input <= MAX_BRIDGE_SIZE)) {
            throw new IllegalArgumentException(OUT_OF_BOUNDS_SIZE_ERROR_MESSAGE);
        }
        return true;
    }

    public static boolean isValidMoving(String input) {
        if (!(input.equals(MOVE_UP) || input.equals(MOVE_DOWN))) {
            throw new IllegalArgumentException(MOVING_INPUT_ERROR_MESSAGE);
        }
        return true;
    }

    public static boolean isValidGameCommand(String input) {
        if (!(input.equals(GAME_RESTART_COMMAND) || input.equals(GAME_QUIT_COMMAND))) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR_MESSAGE);
        }
        return true;
    }
}