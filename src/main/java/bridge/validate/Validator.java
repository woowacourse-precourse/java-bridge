package bridge.validate;

import java.util.List;

public class Validator {
    private static final int MIN_BRIDGE_LENGTH = 3;
    private static final int MAX_BRIDGE_LENGTH = 20;
    private static final String MOVE_UPPER_BRIDGE = "U";
    private static final String MOVE_LOWER_BRIDGE = "D";
    private static final String RETRY = "R";
    private static final String QUIT = "Q";

    public static void isNum(String input) {
        input.chars().forEach(c -> {
            if (!Character.isDigit(c)) {
                String errorMessage = ErrorMessage.ERROR.toString() + ErrorMessage.INPUT_NOT_A_NUMBER;
                throw new IllegalArgumentException(errorMessage);
            }
        });
    }

    public static void isProperBridgeSize(String bridgeSizeInput) {
        int bridgeSize = Integer.parseInt(bridgeSizeInput);
        if (!isInRange(bridgeSize, MIN_BRIDGE_LENGTH, MAX_BRIDGE_LENGTH)) {
            String errorMessage = "" + ErrorMessage.ERROR + ErrorMessage.NUMBER_OUT_OF_RANGE
                    + ErrorMessage.PROPER_BRIDGE_LENGTH;
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static boolean isInRange(int num, int start, int end) {
        return start <= num && num <= end;
    }

    public static void isMove(String move) {
        final List<String> properMoves = List.of(MOVE_UPPER_BRIDGE, MOVE_LOWER_BRIDGE);
        if (!properMoves.contains(move)) {
            String errorMessage = "" + ErrorMessage.ERROR + ErrorMessage.NOT_PROPER_MOVE;
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void isProperGameCommand(String gameCommand) {
        final List<String> properMoves = List.of(RETRY, QUIT);
        if (!properMoves.contains(gameCommand)) {
            String errorMessage = "" + ErrorMessage.ERROR + ErrorMessage.NOT_PROPER_GAME_COMMAND;
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
