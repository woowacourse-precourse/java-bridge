package bridge;

public class Validator {
    public Validator() {
    }

    boolean validateBridgeSize(String inputSize) {
        try {
            validateIsNumeric(inputSize);
            validateIsRightRange(inputSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    void validateIsNumeric(String inputSize) throws IllegalArgumentException {
        if (!inputSize.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMERIC_EXCEPTION_MESSAGE.getExceptionMessage());
        }
    }

    void validateIsRightRange(String inputSize) throws IllegalArgumentException {
        int bridgeSize = Integer.parseInt(inputSize);
        if (bridgeSize < 3 | bridgeSize > 20) {
            throw new IllegalArgumentException(ExceptionMessage.RANGE_EXCEPTION_MESSAGE.getExceptionMessage());
        }
    }

    boolean validateMoving(String inputMoving) {
        try {
            validateIsRightMoving(inputMoving);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    void validateIsRightMoving(String inputMoving) throws IllegalArgumentException {
        if (!inputMoving.equals("U") && !inputMoving.equals("D")) {
            throw new IllegalArgumentException(ExceptionMessage.MOVING_EXCEPTION_MESSAGE.getExceptionMessage());
        }

    }

    boolean validateGameCommand(String command) {
        try {
            validateIsRightCommand(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    void validateIsRightCommand(String command) throws IllegalArgumentException {
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException(ExceptionMessage.GAME_COMMAND_EXCEPTION_MESSAGE.getExceptionMessage());
        }
    }
}
