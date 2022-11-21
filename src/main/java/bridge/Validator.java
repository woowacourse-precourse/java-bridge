package bridge;

public class Validator {
    private static final String SIZE_INPUT_TYPE_ERROR = "[ERROR] 다리 길이는 숫자만 입력할 수 있습니다.";
    private static final String SIZE_RANGE_ERROR = "[ERROR] 다리의 길이는 3 ~ 20 사이의 숫자만 입력할 수 있습니다.";
    private static final String MOVING_WORD_INPUT_ERROR = "[ERROR] 위 쪽('U') 혹은 아래 쪽('D')만 입력할 수 있습니다.";
    private static final String GAME_COMMAND_INPUT_ERROR = "[ERROR] 재시작('R') 혹은 종료('Q')만 입력할 수 있습니다.";
    private static final String SIZE_INPUT_TYPE_CHECK = "[0-9]+";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    public static void validateInputBridgeSizeType(String size) {
        if (!size.matches(SIZE_INPUT_TYPE_CHECK)) {
            throw new IllegalArgumentException(SIZE_INPUT_TYPE_ERROR);
        }
    }

    public static void validateInputBridgeSizeRange(String size) {
        int bridgeSize = Integer.parseInt(size);
        if(bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(SIZE_RANGE_ERROR);
        }
    }

    public static void validateMovingWord(String word) {
        if (!word.equals("U") && !word.equals("D")) {
            throw new IllegalArgumentException(MOVING_WORD_INPUT_ERROR);
        }
    }

    public static void validateGameCommand(String command) {
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException(GAME_COMMAND_INPUT_ERROR);
        }
    }
}