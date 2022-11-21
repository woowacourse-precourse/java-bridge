package bridge.domain.bridge;

import static bridge.validate.BridgeValidation.validatePasserLocation;
import static bridge.value.LocationValue.LOCATION_INCREMENT;
import static bridge.value.LocationValue.LOCATION_INIT;

import java.util.Objects;

public class BridgeLocation {

    private final int location;

    public BridgeLocation(int location) {
        validatePasserLocation(location);

        this.location = location;
    }

    public static BridgeLocation initBridgeLocation() {
        return new BridgeLocation(LOCATION_INIT.getValue());
    }

    public int value() {
        return location;
    }

    public BridgeLocation next() {
        return new BridgeLocation(value() + LOCATION_INCREMENT.getValue());
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
