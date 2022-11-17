package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;

import java.util.List;

public class BridgeService {

    public static Bridge makeBridge(Integer bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeStatus = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridgeStatus);
    }
}
