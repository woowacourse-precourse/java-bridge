package bridge.model;

import bridge.error.Error;
import java.util.Objects;

public class RetryOrQuit {

    private static final String RETRY_SIGNAL = "R";
    private static final String QUIT_SIGNAL = "Q";

    private final String value;

    public RetryOrQuit(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(Error.SYSTEM_ERROR.getMessage());
        }
        validate(value);

        this.value = value;
    }

    public boolean isRetry() {
        return value.equals(RETRY_SIGNAL);
    }

    private void validate(String value) {
        if (!value.equals(RETRY_SIGNAL) && !value.equals(QUIT_SIGNAL)) {
            throw new IllegalArgumentException(Error.RETRY_INPUT_ERROR.getMessage());
        }
    }
}
