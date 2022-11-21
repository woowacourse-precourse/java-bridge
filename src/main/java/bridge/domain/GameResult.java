package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<String> upBridgeResult = new ArrayList<>();
    private List<String> downBridgeResult = new ArrayList<>();
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

    public void setUpBridgeResult(String output) {
        upBridgeResult.add(output);
    }

    public void setDownBridgeResult(String output) {
        downBridgeResult.add(output);
    }

    public void setBridgeGameResult(boolean bridgeGameResult) {
        this.bridgeGameResult = bridgeGameResult;
    }
}
