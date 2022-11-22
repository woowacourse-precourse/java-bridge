package bridge;

import java.util.Objects;

import static bridge.constant.BridgeConstant.*;
import static bridge.constant.ErrorConstant.*;

public class InputViewValidation {

    public static void isValidInput(String input) {
        checkBlankInput(input);
        isDigitInput(input);
    }
    private static void isDigitInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(ERROR_NON_INTEGER);
            }
        }
    }
    private static void checkBlankInput(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_BLANK_INPUT);
        }
    }
    public static void isValidRangeOfBridgeSize(int bridgeSize) {
        if (bridgeSize < BRIDGE_MIN_SIZE || bridgeSize > BRIDGE_MAX_SIZE) {
            throw new IllegalArgumentException(ERROR_OUT_OF_RANGE);
        }
    }

    public static void isValidMovingCommand(String movingCommand) {
        if (!movingCommand.equals(BRIDGE_UP_COMMAND) && !movingCommand.equals(BRIDGE_DOWN_COMMAND)) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_MOVING_COMMAND);
        }
    }

    public static void isValidGameCommand(String gameCommand) {
        if (!gameCommand.equals(BRIDGE_RETRY_COMMAND) && !gameCommand.equals(BRIDGE_QUIT_COMMAND)) {
            throw new IllegalArgumentException(ERROR_NOT_VALID_GAME_COMMAND);
        }
    }
}
