package bridge.util;

public class Validator {

    private static final int VALID_RANGE_START = 3;
    private static final int VALID_RANGE_END = 20;
    private static final String MOVING_UP_COMMAND_LETTER = "U";
    private static final String MOVING_DOWN_COMMAND_LETTER = "D";
    private static final String RETRY_COMMAND_LETTER = "R";
    private static final String QUIT_COMMAND_LETTER = "Q";

    public void validateBridgeSize(int size) {
        if (!isValidRange(size)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDirection(String moving) {
        if (!isValidMoving(moving)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateCommand(String letter) {
        if (!isValidCommand(letter)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isValidRange(int size) {
        return size >= VALID_RANGE_START && size <= VALID_RANGE_END;
    }

    public boolean isValidMoving(String letter) {
        return letter.equals(MOVING_UP_COMMAND_LETTER) || letter.equals(MOVING_DOWN_COMMAND_LETTER);
    }

    public boolean isValidCommand(String letter) {
        return letter.equals(RETRY_COMMAND_LETTER) || letter.equals(QUIT_COMMAND_LETTER);
    }
}