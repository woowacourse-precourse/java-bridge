package bridge.domain;

import java.util.Objects;

public class BridgeLocation {

    private final int location;

    public BridgeLocation(int location) {
        validate(location);
        this.location = location;
    }

    private void validate(int location) {
        if(location < 0) {
            throw new IllegalArgumentException("다리에서의 위치가 양수가 아닙니다.");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BridgeLocation that = (BridgeLocation) o;
        return location == that.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }
}
