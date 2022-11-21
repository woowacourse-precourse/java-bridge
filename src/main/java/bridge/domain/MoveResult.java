package bridge.domain;

import static bridge.constant.Constants.BridgeSign.MOVE_FAIL;
import static bridge.constant.Constants.BridgeSign.MOVE_PASS;

public enum MoveResult {
    PASS(MOVE_PASS, false),
    FAIL(MOVE_FAIL, true);

    private final String result;
    private final boolean isGameLose;

    MoveResult(String result, boolean isGameLose) {
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
