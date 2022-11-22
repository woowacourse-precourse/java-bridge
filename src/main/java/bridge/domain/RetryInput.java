package bridge.domain;

import bridge.Enum.Error;
import bridge.Enum.PlayerInput;

public class RetryInput {
    private final String retry;

    public RetryInput(String input){
        isRetryValid(input);
        this.retry = input;
    }
    public String getRetryInput(){
        return retry;
    }
    public void isRetryValid(String decision) {
        if (!decision.equals(PlayerInput.RESTART.getValue()) && !decision.equals(PlayerInput.QUIT.getValue())) {
            throw new IllegalArgumentException(Error.INPUT_CONTINUE.getMessage());
        }
    }
}
