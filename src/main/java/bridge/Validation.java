package bridge;

public class Validation {
    private final String UP = "U";
    private final String DOWN = "D";
    private final String RETRY = "R";
    private final String QUIT = "Q";

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
        if (!inputDirection.equals(UP) && !inputDirection.equals(DOWN)) {
            throw new IllegalArgumentException();
        }
    }
}
