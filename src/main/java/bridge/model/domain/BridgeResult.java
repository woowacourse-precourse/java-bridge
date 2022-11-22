package bridge.model.domain;

import static bridge.model.constnce.Text.FAIL;
import static bridge.model.constnce.Text.SUCCESS;

public class BridgeResult {
    private String result;
    private int attempt;
    private boolean isClear;

    public BridgeResult() {
        this.result = SUCCESS;
        this.attempt = 0;
        this.isClear = true;
    }

    public void failedRound() {
        isClear = false;
    }

    public void init() {
        isClear = true;
        result = SUCCESS;
    }

    public void addAttempt() {
        attempt += 1;
    }

    public void failedGame() {
        result = FAIL;
    }

    public boolean getIsClear() {
        return isClear;
    }

    public String getResult() {
        return result;
    }

    public int getAttempt() {
        return attempt;
    }
}
