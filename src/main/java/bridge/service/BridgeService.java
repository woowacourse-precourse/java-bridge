package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.Bridge;

import java.util.List;

public class BridgeService {

    public Bridge createBridge(int size) {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        List<String> tempBridge = bridgeMaker.makeBridge(size);
        return Bridge.valueOf(tempBridge);
    }
}
