package bridge.domain.resources.bridge;

import bridge.domain.exception.OutOfBridgeSizeBoundaryException;

public class BridgeSize {

    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;


    private final int size;

    private BridgeSize(final int size) {
        if (!isSizeOfBoundary(size)) {
            throw new OutOfBridgeSizeBoundaryException();
        }

        this.size = size;
    }

    private boolean isSizeOfBoundary(int size) {
        return MIN_BRIDGE_SIZE <= size && size <= MAX_BRIDGE_SIZE;
    }

    public static BridgeSize from(final int size) {  // 정적 팩토리 메소드
        return new BridgeSize(size);
    }

    public int getSize() {
        return size;
    }

}
