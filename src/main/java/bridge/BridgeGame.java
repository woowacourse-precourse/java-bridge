package bridge;

import utils.ConstValue;

public class BridgeGame {

    private final Bridge bridge;

    private int tryCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.tryCount = 0;
    }

    public boolean move(String movingPlace) {
        return bridge.move(movingPlace);
    }

    public void retry() {
        bridge.initBridge();
        tryCount++;
    }

    public int getTryCount() {
        return tryCount;
    }

    public String getGameResult() {
        if (bridge.isCompleted()) {
            return ConstValue.SUCCESS;
        }
        return ConstValue.FAIL;
    }
}
