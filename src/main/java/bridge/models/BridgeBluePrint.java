package bridge.models;

import bridge.enums.BridgeRange;
import bridge.enums.ErrorMessage;

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
