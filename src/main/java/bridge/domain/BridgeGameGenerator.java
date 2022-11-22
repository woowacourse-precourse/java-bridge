package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class BridgeGameGenerator {

    public static BridgeGame generate(int bridgeSize) {
        Bridge bridge = initBridge(bridgeSize);
        return new BridgeGame(bridge);
    }

    private static Bridge initBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeRaw = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(bridgeRaw);
    }
}
