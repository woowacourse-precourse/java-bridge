package bridge.commom.validation;

import bridge.commom.constant.GameCommand;

import static bridge.commom.constant.GameMessage.Exception;

public class InputValidator {

    public static void isPositiveInteger(String input) throws IllegalArgumentException {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(Exception.POSITIVE_INTEGER);
        }
        if (Integer.parseInt(input) == 0) {
            throw new IllegalArgumentException(Exception.POSITIVE_INTEGER);
        }
    }

    public static void isMoveModeCommand(String input) throws IllegalArgumentException {
        if (!(GameCommand.isUpperCommand(input) || GameCommand.isDownCommand(input))) {
            throw new IllegalArgumentException(Exception.MOVE_MODE_COMMAND);
        }
    }

    public static void isRestartModeCommand(String input) throws IllegalArgumentException {
        if (!(GameCommand.isRestartCommand(input) || GameCommand.isQuitCommand(input))) {
            throw new IllegalArgumentException(Exception.RESTART_MODE_COMMAND);
        }
    }
}
