package bridge.controller;

public class InputValidator {
    public int validatePureNumber(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }

    public void validateBridgeSizeRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException();
        }
    }

    public String validateMoving(String input) {
        if (input.equals("U") || input.equals("D")) {
            return input;
        }
        throw new IllegalArgumentException();
    }

    public String validateRestart(String input) {
        if (input.equals("R") || input.equals("Q")) {
            return input;
        }
        throw new IllegalArgumentException();
    }
}
