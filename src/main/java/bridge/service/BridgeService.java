package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class BridgeService {
    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static List<String> generateBridge(String size) {
        List<String> bridge = bridgeMaker.makeBridge(Integer.parseInt(size));
        return bridge;
    }

}
