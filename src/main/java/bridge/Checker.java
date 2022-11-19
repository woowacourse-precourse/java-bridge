package bridge;

import static constant.Values.Message.*;

public class Checker {
    public int checkValidate(String input) throws IllegalArgumentException {
        try {
            return checkNumeric(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(
                    String.format(ERROR_INPUT_VALUE.getMessage(), input) + ERROR_SIZE.getMessage()
                            + ERROR_RE_INPUT.getMessage());
        }
    }

    public int checkNumeric(String input) throws IllegalArgumentException {
        int inputNumber;
        try {
            inputNumber = Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException();
        }
        return checkNegative(inputNumber);
    }

    public int checkNegative(int input) throws IllegalArgumentException {
        if (input < 0) {
            throw new IllegalArgumentException();
        }
        return checkBoundary(input);
    }

    public int checkBoundary(int input) throws IllegalArgumentException {
        if (input < 3 || input > 20) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    public String checkMoveValidate(String move) {
        if (!(move.equals("U") | move.equals("D"))) {
            throw new IllegalArgumentException(
                    String.format(ERROR_INPUT_VALUE.getMessage(), move) + ERROR_MOVE.getMessage() + ERROR_RE_INPUT.getMessage());
        }
        return move;
    }
}
