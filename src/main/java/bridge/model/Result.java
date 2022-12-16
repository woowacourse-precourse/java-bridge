package bridge.model;

import bridge.util.BridgeGameStatus;

import java.util.List;

public class Result {
    private int playCount;
    private boolean result;

    public void addPlayCount() {
        playCount++;
    }

    public int getPlayCount() {
        return playCount;
    }

    public boolean getResult() {
        return result;
    }
    public void setResult(boolean result) {
        this.result = result;
    }


}
