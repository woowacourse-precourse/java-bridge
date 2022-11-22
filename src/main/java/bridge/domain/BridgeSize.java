package bridge.domain;

import bridge.domain.exception.WrongRangeSizeException;

public class BridgeSize {

    public static final int START_INCLUSIVE = 3;
    public static final int END_INCLUSIVE = 20;
    private final int size;

    private BridgeSize(int size) {
        if (!isValidateRange(size)) {
            throw new WrongRangeSizeException();
        }

        this.size = size;
    }

    private boolean isValidateRange(int size) {
        return START_INCLUSIVE <= size && size <= END_INCLUSIVE;
    }

    public static BridgeSize from(int size) {
        return new BridgeSize(size);
    }

    public int getSize() {
        return this.size;
    }
}
