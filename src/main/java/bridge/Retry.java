package bridge;

import static bridge.exception.ExceptionName.BRIDGE_GAME_RETRY_EXCEPTION;

public class Retry {

    private final String retry;

    public Retry(String retry) {
        validate(retry);
        this.retry = retry;
    }

    private void validate(String retry) {
        if (!retry.equals("R") && !retry.equals("Q")) {
            throw new IllegalArgumentException(BRIDGE_GAME_RETRY_EXCEPTION);
        }
    }

    public String getRetry() {
        return retry;
    }
}
