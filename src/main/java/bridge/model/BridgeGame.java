package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private int tryNumber;
    private List<String> preStatus = new ArrayList<>();

    public Bridge makeTargetBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public void move(String whereMoving) {
        this.preStatus.add(whereMoving);
    }

    public void back(int step) {
        this.preStatus.remove(step);
    }

    public void retry() {
        this.tryNumber ++;
    }

    public void setTryNumber() {
        this.tryNumber = 1;
    }

    public void resetTryNumber() {
        this.tryNumber = 0;
    }

    public int getTryNumber() {
        return this.tryNumber;
    }

    public List<String> getPreStatus() {
        return this.preStatus;
    }
}