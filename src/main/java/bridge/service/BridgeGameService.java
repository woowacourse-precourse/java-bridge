package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgePassed;

public class BridgeGameService {

    private final BridgeMaker bridgeMaker;

    public BridgeGameService() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public Bridge createBridge(int bridgeSize) {
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public BridgePassed showBridgePassed(Bridge bridge, int index, String moving) {
        return new BridgePassed(bridge.getSubBridge(index + 1), bridge.canMove(index, moving));
    }
}
