package bridge.model;

import bridge.validation.Validation;

public class BridgeSize {
    private int size;

    public BridgeSize(String input) {
        int size = Validation.toInt(input);
        Validation.ofBridgeSize(size);
        this.size = size;
    }

    public int get() {
        return size;
    }
}
