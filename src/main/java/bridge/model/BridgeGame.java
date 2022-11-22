package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class BridgeGame {
    private final Status preStatus;

    public BridgeGame() {
        preStatus = new Status();
    }

    public Bridge makeTargetBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> newBridge = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(newBridge);
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