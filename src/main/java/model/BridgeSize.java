package model;

import static constant.Config.ERROR;

public class BridgeSize {
    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 20;
    private static final String RANGE_ERROR = ERROR + String.format("다리 길이는 %d부터 %d 사이여야 합니다.", MIN_RANGE, MAX_RANGE);
    private final int size;

    public BridgeSize(int size) {
        validateRange(size);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    private void validateRange(int size) {
        if (size < MIN_RANGE || size > MAX_RANGE) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }
}
