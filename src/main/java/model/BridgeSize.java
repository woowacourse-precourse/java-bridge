package model;

import validation.Validation;

public class BridgeSize {
    private int size;

    public BridgeSize(String input) {
        int size = Validation.toInt(input);
        Validation.ofBridgeSize(size);
        this.size = size;
    }

    public boolean isEqual(int number) {
        return size == number;
    }
}
