package bridge.domain;

import java.util.NoSuchElementException;

import static bridge.exception.ExceptionMessage.*;

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
            System.out.println(NUMBER_FORMAT_EXCEPTION.getMessage());
            throw new NoSuchElementException(NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    private void validateRangeOfSize(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(OUT_OF_BRIDGE_RANGE_EXCEPTION.getMessage());
        }
    }
}
