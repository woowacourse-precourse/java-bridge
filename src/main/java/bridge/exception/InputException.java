package bridge.exception;

import bridge.command.GameCommand;
import bridge.command.MovingCommand;
import bridge.exception.phrases.ExceptionPhrases;

public class InputException {
    public static void validateBridgeSize(int size) {
        if (!(size >= 3 && size <= 20)) {
            throw new IllegalArgumentException(ExceptionPhrases.BridgeSizeRange.getPhrase());
        }
    }

    public static int convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionPhrases.BridgeSizeNumber.getPhrase());
        }
    }

    public static void validateMovingCommand(String command) {
        if (!(command.equals(MovingCommand.UpStairs.get()) || command.equals(MovingCommand.DownStairs.get()))) {
            throw new IllegalArgumentException(ExceptionPhrases.MovingValue.getPhrase());
        }
    }

    public static void validateGameCommand(String command) {
        if (!(command.equals(GameCommand.Restart.get()) || command.equals(GameCommand.Quit.get()))) {
            throw new IllegalArgumentException(ExceptionPhrases.GameCommand.getPhrase());
        }
    }
}
