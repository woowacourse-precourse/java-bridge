package bridge;

import bridge.Constant.OutputValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeGame {
    private final List<String> bridge;
    private final List<String> resultBridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        resultBridge = new ArrayList<>();
    }

    public void move(String selectBlock) {
        if (bridge.get(resultBridge.size()).equals(selectBlock)) {
            resultBridge.add(OutputValue.rightBlock.get());
            return;
        }
        resultBridge.add(OutputValue.wrongBlock.get());
    }

    public void retry() {
        resultBridge.clear();
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public int getResultBridgeSize() {
        return resultBridge.size();
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public List<String> getResultBridge() {
        return Collections.unmodifiableList(resultBridge);
    }
}