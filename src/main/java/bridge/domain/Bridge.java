package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {

    private static List<String> bridge;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    public Bridge() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridge = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(User.getBridgeSize());
    }

    public static List<String> getBridge() {
        return bridge;
    }
}
