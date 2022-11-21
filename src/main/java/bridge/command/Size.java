package bridge.command;

import static bridge.config.ExceptionMessage.WRONG_SIZE_FORMAT;
import static bridge.config.ExceptionMessage.NUMBER_OUT_OF_RANGE;

public class Size {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private final int size;

    public int getSize() {
        return size;
    }

    public Size(String size) {
        this.size = validateOnlyNumber(size);
        validate(this.size);
    }

    public void validate(int size) {
        validateSizeRange(size);
    }

    private void validateSizeRange(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.toString());
        }
    }

    private int validateOnlyNumber(String size) {
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_SIZE_FORMAT.toString());
        }
    }
}
