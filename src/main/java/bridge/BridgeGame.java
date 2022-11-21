package bridge;

import java.util.List;

public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final BridgePlay bridgePlay;
    private List<String> bridge;
    private int currentPosition = -1;
    private int totalTryCount = 1;
    private boolean success = true;
    private boolean complete = false;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgePlay = new BridgePlay();
    }

    public void requestBridge() {
        int bridgeSize = bridgeMaker.requestReadBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public void move() {
        currentPosition++;
        String moveCommand = bridgePlay.requestReadMoving();
        if (!bridge.get(currentPosition).equals(moveCommand)) {
            success = false;
            return;
        }
        if (currentPosition == bridge.size() - 1) {
            complete = true;
        }
    }


    public boolean retry() {
        if (bridgePlay.requestReadRetry().equals("R")) {
            currentPosition = -1;
            success = true;
            totalTryCount++;
            return true;
        }
        return false;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getTotalTryCount() {
        return totalTryCount;
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isComplete() {
        return complete;
    }
}
