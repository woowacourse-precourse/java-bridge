package bridge.model;

import bridge.exception.BridgeSizeException;

public class Bridge {

    private int validateSize(String size) {
        BridgeSizeException.validate(size);
        return Integer.parseInt(size);
    }
}
