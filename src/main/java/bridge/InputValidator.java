package bridge;

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
        if (input.equals("U") || input.equals("u") || input.equals("D") || input.equals("d")) {
            return input;
        }
        throw new IllegalArgumentException();
    }

    public String validateRestart(String input) {
        if (input.equals("R") || input.equals("r") || input.equals("Q") || input.equals("q")) {
            return input;
        }
        throw new IllegalArgumentException();
    }
}
