package bridge.input;

import bridge.game.BridgeSize;
import bridge.game.GameCommand;
import bridge.game.Moving;

public class Validator {

    public static void bridgeSize(String bridgeSize) {
        isLengthInRange(bridgeSize);
        isFirstLetterZero(bridgeSize);
        isNumber(bridgeSize);
        isInRange(bridgeSize);
    }

    public static void moving(String moving) {
        if (moving.equals(Moving.UP.getLetter())) {
            return;
        }

        if (moving.equals(Moving.DOWN.getLetter())) {
            return;
        }

        throw new IllegalArgumentException(Exception.MOVING.getMessage());
    }

    public static void gameCommand(String gameCommand) {
        if (gameCommand.equals(GameCommand.RETRY.getLetter())) {
            return;
        }

        if (gameCommand.equals(GameCommand.QUIT.getLetter())) {
            return;
        }

        throw new IllegalArgumentException(Exception.GAME_COMMAND.getMessage());
    }

    private static void isLengthInRange(String bridgeSize) {
        int length = bridgeSize.length();

        if (length < BridgeSize.MINIMUM_LENGTH.getNumber() || length > BridgeSize.MAXIMUM_LENGTH.getNumber()) {
            throw new IllegalArgumentException(Exception.LENGTH.getMessage());
        }
    }

    private static void isFirstLetterZero(String bridgeSize) {
        char firstLetter = bridgeSize.charAt(0);

        if (firstLetter == '0') {
            throw new IllegalArgumentException(Exception.FIRST_LETTER.getMessage());
        }
    }

    private static void isNumber(String bridgeSize) {
        for (int index = 0; index < bridgeSize.length(); index++) {
            char letter = bridgeSize.charAt(index);

            if (!Character.isDigit(letter)) {
                throw new IllegalArgumentException(Exception.NUMBER.getMessage());
            }
        }
    }

    private static void isInRange(String bridgeSize) {
        int number = Integer.parseInt(bridgeSize);

        if (number < BridgeSize.MINIMUM.getNumber() || number > BridgeSize.MAXIMUM.getNumber()) {
            throw new IllegalArgumentException(Exception.RANGE.getMessage());
        }
    }
}
