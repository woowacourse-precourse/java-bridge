package bridge.exception;

import static bridge.exception.ExceptionMessage.*;
import static bridge.service.PlayerCommend.MOVE_LOWER;
import static bridge.service.PlayerCommend.MOVE_UPPER;

public class InputException extends IllegalArgumentException {
    private static final int MAX_SIZE = 20;
    private static final int MIN_SIZE = 3;
    private static final int ONE_WORD = 1;
    private static final int TWO_WORD = 2;

    public void validateBridgeSize(String readLine) {
        validateInputLength(readLine);
        notDigit(readLine);
        outOfRange(readLine);
    }

    public void validateMoveCommend(String commend) {
        if (commend.length() != ONE_WORD) {
            throw new IllegalArgumentException(NOT_LENGTH.getMessage());
        }
        if (commend.equals(MOVE_LOWER.getCommend()) || commend.equals(MOVE_UPPER.getCommend())) {
            return;
        }
        throw new IllegalArgumentException(NOT_MOVE_COMMEND.getMessage());
    }

    private void notDigit(String readLine) {
        for (char readOne : readLine.toCharArray()) {
            if (!Character.isDigit(readOne)) {
                throw new IllegalArgumentException(NOT_NUMBER.getMessage());
            }
        }
    }

    private void outOfRange(String readLine) {
        int size = Integer.parseInt(readLine);
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(NOT_RANGE.getMessage());
        }
    }

    private void validateInputLength(String readLine) {
        if (readLine.length() > TWO_WORD || readLine.length() < ONE_WORD) {
            throw new IllegalArgumentException(NOT_LENGTH.getMessage());
        }
    }
}
