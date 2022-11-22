package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {

    private List<String> upBridgeResult;
    private List<String> downBridgeResult;
    private boolean bridgeGameResult;

    public GameResult() {
        this.upBridgeResult = new ArrayList<>();
        this.downBridgeResult = new ArrayList<>();
        this.bridgeGameResult = true;
    }

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
