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

    private void validate(String value) {
        if (value.length() != VALUE_LENGTH) {
            throw new IllegalArgumentException(Error.DIRECTION_INPUT_ERROR.getMessage());
        }
        if (!value.equals(UP_SIGN) && !value.equals(DOWN_SIGN)) {
            throw new IllegalArgumentException(Error.DIRECTION_INPUT_ERROR.getMessage());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpOrDown upOrDown = (UpOrDown) o;
        return Objects.equals(value, upOrDown.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
