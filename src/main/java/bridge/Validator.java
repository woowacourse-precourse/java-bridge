package bridge;

import static bridge.util.Constant.*;

public class Validator {

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

    public static void validateRetryGameCommand(String command) {
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException(RETRY_COMMAND_INPUT);
        }
    }
}