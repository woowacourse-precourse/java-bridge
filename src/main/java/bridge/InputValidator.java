package bridge;

public class InputValidator {
    public int validateBridgeSize(String input) throws NumberFormatException {
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize >= 3 && bridgeSize <= 20) {
            return bridgeSize;
        }
        throw new IllegalArgumentException();
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
