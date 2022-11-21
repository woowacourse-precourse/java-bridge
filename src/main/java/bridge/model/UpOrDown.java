package bridge.model;

import bridge.error.Error;
import java.util.Objects;

public class UpOrDown {

    public static final String UP_SIGN = "U";
    public static final String DOWN_SIGN = "D";
    private static final int VALUE_LENGTH = 1;

    private final String value;

    public UpOrDown(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(Error.SYSTEM_ERROR.getMessage());
        }
        validate(value);

        this.value = value;
    }

    public boolean isUp() {
        return value.equals(UP_SIGN);
    }

    public boolean isDown() {
        return value.equals(DOWN_SIGN);
    }

    public String getValue() {
        return value;
    }

    private void validate(String value) {
        if (value.length() != VALUE_LENGTH) {
            throw new IllegalArgumentException(Error.DIRECTION_INPUT_ERROR.getMessage());
        }
        if (!value.equals(UP_SIGN) && !value.equals(DOWN_SIGN)) {
            throw new IllegalArgumentException(Error.DIRECTION_INPUT_ERROR.getMessage());
        }
    }
}
