package bridge.util;

public class Validator {

    public boolean isValidBridgeSize(int size) {
        return size >= 3 && size <= 20;
    }
}