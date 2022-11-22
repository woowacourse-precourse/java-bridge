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
        validate(output);
        upBridgeResult.add(output);
    }

    public void setDownBridgeResult(String output) {
        validate(output);
        downBridgeResult.add(output);
    }

    public void setBridgeGameResult(boolean bridgeGameResult) {
        this.bridgeGameResult = bridgeGameResult;
    }

    public void validate(String output) {
        if (!output.equals("O") && !output.equals("X") && !output.equals(" ")) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값이 들어왔습니다.");
        }
    }
}
