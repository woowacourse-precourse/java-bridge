package bridge.domain;

public class BridgeLocation {

    private int location;

    public BridgeLocation(int location) {
        this.location = location;
    }

    public static BridgeLocation initBridgeLocation() {
        return new BridgeLocation(0);
    }

    public int value() {
        return location;
    }

    public BridgeLocation next() {
        return new BridgeLocation(value() + 1);
    }

    public boolean isBelow(int size) {
        return value() <= size;
    }
}
