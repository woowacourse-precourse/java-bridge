package bridge.business;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {
    private final BridgeGame bridgeGame;

    private int tryCount;
    private boolean success;
    private List<String> bridge;

    public BridgeResult(BridgeGame bridgeGame){
        this.tryCount = 0;
        this.success = true;
        this.bridge = new ArrayList<>();
        this.bridgeGame = bridgeGame;
    }
    public void move(String movingKey) throws IndexOutOfBoundsException, IllegalArgumentException {
        bridge.add(movingKey);
        int lastIndex = bridge.size()-1;
        this.success = bridgeGame.move(movingKey, lastIndex);
    }

    public void refresh() {
        tryCount++;
        success = true;
        bridge.clear();
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }
}
