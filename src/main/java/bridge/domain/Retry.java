package bridge.domain;

import static bridge.constant.Commands.QUIT_COMMAND;
import static bridge.constant.Commands.RETRY_COMMAND;
import static bridge.constant.ExceptionName.BRIDGE_GAME_RETRY_EXCEPTION;

public class Retry {

    private final String retry;

    public Retry(String retry) {
        validate(retry);
        this.retry = retry;
    }

    private void validate(String retry) {
        if (!retry.equals(RETRY_COMMAND) && !retry.equals(QUIT_COMMAND)) {
            throw new IllegalArgumentException(BRIDGE_GAME_RETRY_EXCEPTION);
        }
    }

    public String getRetry() {
        return retry;
    }
}
