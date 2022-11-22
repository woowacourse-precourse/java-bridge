package bridge.domain;

import bridge.Enum.Error;
import bridge.Enum.PlayerInput;

public class RetryInput {
    private final String retry;

    public RetryInput(String input){
        isRetryValid(input);
        this.retry = input;
    }
    public void isRetryValid(String decision) {
        if (!decision.equals(PlayerInput.RESTART) && !decision.equals(PlayerInput.QUIT)) {
            throw new IllegalArgumentException(Error.INPUT_CONTINUE.getMessage());
        }
    }
}
