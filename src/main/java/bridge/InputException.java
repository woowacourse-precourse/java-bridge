package bridge;

import constants.Error;
import constants.GameCommand;

public class InputException {
    private static final int START_RANGE = 3;
    private static final int END_RANGE = 20;

    public static void exceptionNumber(String input) {
        char check[] = input.toCharArray();
        for (int i = 0; i < check.length; i++) {
            if (!Character.isDigit(check[i])) {
                throw new IllegalArgumentException(Error.INPUT_RANGE_OUT.getMsg());
            }
        }
    }

    public static void exceptionRange(int input) {
        if (input < START_RANGE || input > END_RANGE) {
            throw new IllegalArgumentException(Error.INPUT_RANGE_OUT.getMsg());
        }
    }

    public static void exceptionMoving(String input) {
        if (!(input.equals(GameCommand.UP.getGameCommand()) || input.equals(GameCommand.DOWN.getGameCommand()))) {
            throw new IllegalArgumentException(Error.INPUT_MOVING.getMsg());
        }
    }

    public static void exceptionGameCommand(String input) {
        if (!(input.equals(GameCommand.RESTART.getGameCommand()) || input.equals(GameCommand.END.getGameCommand()))) {
            throw new IllegalArgumentException(Error.INPUT_GAME_COMMAND.getMsg());
        }
    }
}