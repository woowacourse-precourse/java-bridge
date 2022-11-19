package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class BridgeMakerService {
    private BridgeMaker bridgeMaker;
    private List<String> bridge;

    public BridgeMakerService() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getBridgeSize() {
        return bridge.size();
    }


    public void setBridge(int bridgeSize) {
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
    }
}
