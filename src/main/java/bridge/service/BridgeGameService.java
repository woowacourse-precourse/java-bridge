package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.GameResult;

import java.util.ArrayList;

public class BridgeGameService {
    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static Bridge initBridge(String size) {
        Bridge bridge = bridgeMaker.makeBridge(Integer.parseInt(size));
        return bridge;
    }

    public static int initTryCount() {
        return 1;
    }

    public static int initCount() {
        return 0;
    }
}
