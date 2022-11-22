package bridge.model;

import bridge.error.Error;
import java.util.Objects;

public class PassOrFail {

    private final boolean value;
    private final UpOrDown upOrDown;

    public PassOrFail(boolean value, UpOrDown upOrDown) {
        if (Objects.isNull(upOrDown)) {
            throw new IllegalArgumentException(Error.SYSTEM_ERROR.getMessage());
        }

        this.value = value;
        this.upOrDown = upOrDown;
    }

    public boolean getValue() {
        return value;
    }

    public UpOrDown getUpOrDown() {
        return upOrDown;
    }
}
