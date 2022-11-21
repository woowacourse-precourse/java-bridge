package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeMaker;

import java.util.List;

public class BridgeGameService {
    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static List<String> initBridge(String size) {
        List<String> bridge = bridgeMaker.makeBridge(Integer.parseInt(size));
        return bridge;
    }

}
