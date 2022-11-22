package bridge.util;

public class InputValidator {

    private static final String NO_INTEGER_ERROR = "[ERROR] 다리 길이는 문자열이 아닌 숫자여야 합니다.\n";
    private static final String BRIDGE_SIZE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.\n";
    private static final String BRIDGE_MOVING_ERROR = "[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자여야 합니다.\n";
    private static final String GAME_COMMAND_ERROR = "[ERROR] 재시작/종료 여부는 R(재시작)과 Q(종료) 중 하나의 문자여야 합니다.\n";
    private static final String UP_MOVING_CHARACTER = "U";
    private static final String DOWN_MOVING_CHARACTER = "D";
    private static final String RETRY_COMMAND_CHARACTER = "R";
    private static final String QUIT_COMMAND_CHARACTER = "Q";

    public static void validateBridgeSize(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NO_INTEGER_ERROR);
        }
    }

    public static void validateBridgeSizeRange(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20){
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR);
        }
    }

    public static void validateMoving(String moving) {
        if (!moving.equals(UP_MOVING_CHARACTER) && !moving.equals(DOWN_MOVING_CHARACTER)){
            throw new IllegalArgumentException(BRIDGE_MOVING_ERROR);
        }
    }

    public static void validateGameCommand(String gameCommand) {
        if (!gameCommand.equals(RETRY_COMMAND_CHARACTER) && !gameCommand.equals(QUIT_COMMAND_CHARACTER)){
            throw new IllegalArgumentException(GAME_COMMAND_ERROR);
        }

    }
}