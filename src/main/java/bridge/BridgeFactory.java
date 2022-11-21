package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeFactory {

    private final BridgeMaker bridgeMaker;

    public BridgeFactory() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public List<String> makeBridgeByBridgeMaker(int bridgeSize) {
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public Bridge makeUserBridge() {
        return new Bridge(new ArrayList<>(), new ArrayList<>());
    }
}
