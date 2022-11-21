package bridge.domain;

import static bridge.constant.Constants.BridgeSign.MOVING_FAIL;
import static bridge.constant.Constants.BridgeSign.MOVING_PASS;

public enum MovingResult {
    PASS(MOVING_PASS, false),
    FAIL(MOVING_FAIL, true);

    private final String result;
    private final boolean isGameLose;

    MovingResult(String result, boolean isGameLose) {
        this.result = result;
        this.isGameLose = isGameLose;
    }

    public String getResult() {
        return result;
    }

    public boolean getIsGameLose() {
        return isGameLose;
    }
}
