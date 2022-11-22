package bridge.service;

import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.Player;

import java.util.List;

public class BridgeService {
    private final BridgeMaker bridgeMaker;

    public BridgeService(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }
    public Bridge makeBridge(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        return new Bridge(size, bridge);
    }

    public void move(Bridge bridge, Player player) {

    }
}
