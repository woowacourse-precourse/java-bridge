package bridge.validator;

import bridge.exception.CommandFormatException;

public class GameCommandValidator {
    private final static String COMMAND_FORMAT = "[R/Q]";

    public static void validateCommand(String direction) {
        if (!direction.matches(COMMAND_FORMAT)) {
            throw new CommandFormatException();
        }
    }
}
