package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;

import java.util.List;

public class BridgeGameService {
    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static Bridge initBridge(String size) {
        List<String> bridgeStatus = bridgeMaker.makeBridge(Integer.parseInt(size));
        return new Bridge(bridgeStatus);
    }

    public static int initTryCount() {
        return 1;
    }

    public static int initCount() {
        return 0;
    }
}
