package bridge.domain;

import java.util.NoSuchElementException;

public class BridgeSize {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private final int size;

    public BridgeSize(String input) {
        int value = parseInt(input);
        validateRangeOfSize(value);
        this.size = value;
    }

    public int getSize() {
        return size;
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] ");
            throw new NoSuchElementException("");
        }
    }

    private void validateRangeOfSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
