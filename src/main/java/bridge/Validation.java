package bridge;

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
}
