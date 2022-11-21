package bridge.domain;

import bridge.constant.BridgeSymbol;

public class GameResult {
    private String success;
    private int attemptNumber;

    public GameResult() {
        success = BridgeSymbol.SUCCESS.getState();
        attemptNumber = 0;
    }

    public void addAttemptNumber() {
        attemptNumber += 1;
    }

    public void changeSuccess() {
        success = BridgeSymbol.SUCCESS.getState();
    }

    public void changeFail() {
        success = BridgeSymbol.FAIL.getState();
    }

    public String getSuccess() {
        return success;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

}
