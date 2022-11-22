package bridge.models;

import bridge.enums.BridgeRange;
import bridge.enums.ErrorMessage;

/**
 * 다리 길이를 가지고 있는 class
 */
public class BridgeBluePrint {

    private int size;

    public BridgeBluePrint(int size) {
        if (!BridgeRange.isWithinRange(size)) {
            throw new IllegalStateException(
                    ErrorMessage.getMessage("OUT_OF_RANGE_BRIDGE_SIZE"));
        }
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
