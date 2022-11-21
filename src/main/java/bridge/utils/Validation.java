package bridge.utils;

import static bridge.domain.ErrorMessage.BRIDGE_SIZE_INCORRECT_INPUT;
import static bridge.domain.ErrorMessage.BRIDGE_INCORRECT_SIZE;
import static bridge.domain.ErrorMessage.GAME_COMMAND_INCORRECT_INPUT;
import static bridge.domain.ErrorMessage.MOVING_INCORRECT_INPUT;
import static bridge.utils.Constants.BRIDGE_MAX_SIZE;
import static bridge.utils.Constants.BRIDGE_MIN_SIZE;

import bridge.domain.GameCommand;
import bridge.domain.Moving;

public class Validation {

    public static void validateBridgeSize(String input) {
        if (hasNonDigitCharacter(input)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_INCORRECT_INPUT.toString());
        }
        if (isOutOfRange(input)) {
            throw new IllegalArgumentException(BRIDGE_INCORRECT_SIZE.toString());
        }
    }

    public static void validateMoving(String input) {
        if (isNotUpOrDown(input)) {
            throw new IllegalArgumentException(MOVING_INCORRECT_INPUT.toString());
        }
    }

    public static void validateGameCommand(String input) {
        if (isNotRestartOrQuit(input)) {
            throw new IllegalArgumentException(GAME_COMMAND_INCORRECT_INPUT.toString());
        }
    }

    private static boolean hasNonDigitCharacter(String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    private static boolean isOutOfRange(String input) {
        int bridgeSize = Integer.parseInt(input);
        return bridgeSize > BRIDGE_MAX_SIZE || bridgeSize < BRIDGE_MIN_SIZE;
    }

    private static boolean isNotUpOrDown(String input) {
        return !input.equals(Moving.UP.getCommand()) && !input.equals(Moving.DOWN.getCommand());
    }

    private static boolean isNotRestartOrQuit(String input) {
        return !input.equals(GameCommand.RESTART.getCommand()) && !input.equals(GameCommand.QUIT.getCommand());
    }
}
