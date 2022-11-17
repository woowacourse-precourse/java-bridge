package bridge.size;

import static bridge.config.ExceptionMessage.NOT_NUMBER_SIZE;

public class BridgeSize {
    private final int size;

    public BridgeSize(String size) {
        this.size = validateOnlyNumber(size);
    }

    public void validate(int size) {

    }

    private int validateOnlyNumber(String size) {
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_SIZE.toString());
        }
    }
}
