package bridge.model;

import bridge.BridgeRandomNumberGenerator;

public class BridgeGame {
    private Status preStatus;

    public BridgeGame() {
        preStatus = new Status();
    }

    public Bridge makeTargetBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public void move(String whereMoving) {
        preStatus.add(whereMoving);
    }

    public void back(int step) {
        preStatus.remove(step);
    }

    public void retry() {
        preStatus.raiseTryNumber();
    }

    public void setTryNumber() {
        preStatus.setOneTryNumber();
    }

    public void resetTryNumber() {
        preStatus.setZeroTryNumber();
    }

    public int getTryNumber() {
        return preStatus.getTryNumber();
    }

    public Status getPreStatus() {
        return preStatus;
    }
}