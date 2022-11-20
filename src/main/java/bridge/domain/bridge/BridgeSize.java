package bridge.domain.bridge;

import bridge.domain.Message;

public class BridgeSize {
    private int size;

    public BridgeSize(String s) {
        validate(s);
        this.size = Integer.parseInt(s);
    }

    public int get() {
        return this.size;
    }

    private void validate(String s) {
        isNumeric(s);
        isSizeInRange(s);
    }

    private boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(Message.ERROR_SIZE_NOT_INTEGER.get());
        }
    }

    private void isSizeInRange(String s) {
        int size = Integer.parseInt(s);
        if (size > 20 || size < 3) {
            throw new IllegalArgumentException(Message.ERROR_SIZE_OUT_OF_RANGE.get());
        }
    }
}
