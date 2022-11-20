package bridge.domain;

import java.util.List;

public class GameResult {

    private List<String> upBridgeResult;
    private List<String> downBridgeResult;
    private boolean bridgeGameResult;

    public List<String> getUpBridgeResult() {
        return upBridgeResult;
    }

    public List<String> getDownBridgeResult() {
        return downBridgeResult;
    }

    public boolean isBridgeGameResult() {
        return bridgeGameResult;
    }

    public void setBridgeGameResult(boolean bridgeGameResult) {
        this.bridgeGameResult = bridgeGameResult;
    }
}
