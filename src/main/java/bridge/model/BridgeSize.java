package bridge.model;

import bridge.error.Error;
import java.util.Objects;

public class BridgeSize {

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;

    private final int value;

    public BridgeSize(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(Error.SYSTEM_ERROR.getMessage());
        }
        validate(value);

        this.value = Integer.parseInt(value);
    }

    private void validate(String value) {
        if (value.length() > 2) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE_RANGE_ERROR.getMessage());
        }
        if (!value.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE_TYPE_ERROR.getMessage());
        }
        if (Integer.parseInt(value) < MIN_SIZE || Integer.parseInt(value) > MAX_SIZE) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE_RANGE_ERROR.getMessage());
        }
    }

    public int getBridgeSize() {
        return value;
    }
}
