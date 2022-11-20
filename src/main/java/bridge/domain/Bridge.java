package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {
    private final int bridgeSize;
    private List<String> bridge;

    public Bridge(int bridgeSize) {
        this.bridgeSize = bridgeSize;
        requestNewBridge();
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    private void requestNewBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public String getBridgeMove(int moveIdx) {
        return bridge.get(moveIdx);
    }
}
