package bridge.input;

import bridge.game.Moving;
import bridge.input.message.Exception;

public class Validator {

    private static final int MINIMUM_BRIDGE_SIZE_LENGTH = 1;
    private static final int MAXIMUM_BRIDGE_SIZE_LENGTH = 2;
    private static final int MINIMUM_BRIDGE_SIZE = 3;
    private static final int MAXIMUM_BRIDGE_SIZE = 20;

    public static void bridgeSize(String bridgeSize) {
        isLengthInRange(bridgeSize);
        isNumber(bridgeSize);
        isInRange(bridgeSize);
    }

    public static void moving(String moving) {
        if (!(moving.equals(Moving.UP.getLetter()) || moving.equals(Moving.DOWN.getLetter()))) {
            throw new IllegalArgumentException(Exception.MOVING.getMessage());
        }
    }

    public static void gameCommand(String gameCommand) {
        if (!(gameCommand.equals(Command.RETRY.getLetter()) || gameCommand.equals(Command.QUIT.getLetter()))) {
            throw new IllegalArgumentException(Exception.GAME_COMMAND.getMessage());
        }
    }

    private static void isLengthInRange(String bridgeSize) {
        int bridgeSizeLength = bridgeSize.length();
        if (bridgeSizeLength < MINIMUM_BRIDGE_SIZE_LENGTH || bridgeSizeLength > MAXIMUM_BRIDGE_SIZE_LENGTH) {
            throw new IllegalArgumentException(Exception.LENGTH.getMessage());
        }
    }

    private static void isNumber(String bridgeSize) {
        char firstLetter = bridgeSize.charAt(0);
        if (firstLetter == '0') {
            throw new IllegalArgumentException(Exception.FIRST_LETTER.getMessage());
        }

        for (int index = 0; index < bridgeSize.length(); index++) {
            char letter = bridgeSize.charAt(index);
            if (!Character.isDigit(letter)) {
                throw new IllegalArgumentException(Exception.NUMBER.getMessage());
            }
        }
    }

    private static void isInRange(String bridgeSize) {
        int number = Integer.parseInt(bridgeSize);
        if (number < MINIMUM_BRIDGE_SIZE || number > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(Exception.RANGE.getMessage());
        }
    }
}
