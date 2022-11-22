package bridge.validation;

import static bridge.validation.ErrorMessage.ERROR_INVALID_BRIDGE_SIZE;
import static bridge.validation.ErrorMessage.ERROR_INVALID_GAME_COMMAND;
import static bridge.validation.ErrorMessage.ERROR_INVALID_MOVE_COMMAND;

import bridge.command.GameCommand;
import bridge.command.MoveCommand;

public class Validation {
    public static void validateGameCommand(String userInput) {
        if (!GameCommand.exist(userInput)) {
            throw new IllegalArgumentException(ERROR_INVALID_GAME_COMMAND);
        }
    }

    public static void validateMoveCommand(String userInput) {
        if (!MoveCommand.exist(userInput)) {
            throw new IllegalArgumentException(ERROR_INVALID_MOVE_COMMAND);
        }
    }

    public static void validateBridgeSize(String userInput) {
        isEmpty(userInput);
        isNumeric(userInput);
        isBridgeSizeInRange(userInput);
    }

    private static void isEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_SIZE);
        }
    }

    private static void isNumeric(String userInput) {
        if (!userInput.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_SIZE);
        }
    }

    private static void isBridgeSizeInRange(String userInput) {
        int bridgeSize = Integer.parseInt(userInput);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_SIZE);
        }
    }
}