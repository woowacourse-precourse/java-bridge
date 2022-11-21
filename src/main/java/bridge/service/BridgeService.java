package bridge.service;

import bridge.Application;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

public class BridgeService {
    private static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static List<String> initBridge(String size) {
        List<String> bridge = bridgeMaker.makeBridge(Integer.parseInt(size));
        return bridge;
    }

}
