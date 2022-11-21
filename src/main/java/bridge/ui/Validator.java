package bridge.ui;

import static bridge.constant.ErrorCode.*;
import static bridge.constant.Const.*;

public class Validator {
    private static final int SHORTEST_LENGTH = 3;
    private static final int LONGEST_LENGTH = 20;

    public Validator() {
    }

    public static void bridgeSizeValidate(String size) {
        if (!(isNotWrongLength(size) && isOnlyContainDigit(size) && isNotWrongRange(size))) {
            throw new IllegalArgumentException(WRONG_BRIDGE_SIZE_INPUT);
        }
    }

    public static void moveValidate(String move) {
        if (!(UP.equals(move) || DOWN.equals(move))) {
            throw new IllegalArgumentException(WRONG_MOVE_INPUT);
        }
    }

    public static void gameCommandValidate(String gameCommand) {
        if (!(RETRY.equals(gameCommand) || QUIT.equals(gameCommand))) {
            throw new IllegalArgumentException(WRONG_GAME_COMMAND_INPUT);
        }
    }

    private static boolean isNotWrongLength(String input) {
        return input.length() == 1 || input.length() == 2;
    }

    private static boolean isOnlyContainDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (!Character.isDigit(character)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isNotWrongRange(String input) {
        int bridgeLength = Integer.parseInt(input);

        return SHORTEST_LENGTH <= bridgeLength && bridgeLength <= LONGEST_LENGTH;
    }
}
