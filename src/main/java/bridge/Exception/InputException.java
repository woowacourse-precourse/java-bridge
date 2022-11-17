package bridge.Exception;

import static bridge.Exception.ExceptionMessage.NOT_NUMBER;
import static bridge.Exception.ExceptionMessage.NOT_RANGE;

public class InputException extends IllegalArgumentException {
    private static final int MAX_SIZE = 20;
    private static final int MIN_SIZE = 3;

    public void validateBridgeSize(String readLine) {
        notDigit(readLine);
        outOfRange(readLine);
    }

    private void notDigit(String readLine) {
        for (char readOne : readLine.toCharArray()) {
            if (!Character.isDigit(readOne)) {
                throw new IllegalArgumentException(NOT_NUMBER.getMessage());
            }
        }
    }

    public void outOfRange(String readLine) {
        int size = Integer.parseInt(readLine);
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(NOT_RANGE.getMessage());
        }
    }
}
