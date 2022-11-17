package bridge;

import bridge.util.Constant;

public class Validation {
    public void checkOnlyNumber(String inputSize) throws IllegalArgumentException {
        try {
            Integer.parseInt(inputSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidBridgeSize(String inputSize) throws IllegalArgumentException {
        int size = Integer.parseInt(inputSize);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidDirection(String inputDirection) throws IllegalArgumentException {
        if (!inputDirection.equals(Constant.UP) && !inputDirection.equals(Constant.DOWN)) {
            throw new IllegalArgumentException();
        }
    }

    public void isValidGameCommand(String inputCommand) throws IllegalArgumentException {
        if (!inputCommand.equals(Constant.RETRY) && !inputCommand.equals(Constant.QUIT)) {
            throw new IllegalArgumentException();
        }
    }
}
