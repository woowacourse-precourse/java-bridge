package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.domain.Bridge;

import java.util.List;

public class DefaultBridgeGameService implements BridgeGameService {


    @Override
    public Bridge createBridge(int bridgeSize, BridgeNumberGenerator generator) {
        BridgeMaker maker = new BridgeMaker(generator);
        List<String> madeBridge = maker.makeBridge(bridgeSize);
        Bridge bridge = new Bridge(madeBridge);
        return bridge;
    }

}
