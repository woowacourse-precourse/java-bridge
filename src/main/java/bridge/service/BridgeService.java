package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import java.util.List;

public class BridgeService {
    private final ViewService viewService = new ViewService();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public Bridge bridgeMaker() {
        int bridgeSize = askBridgeSize();
        Bridge bridge = new Bridge(makeBridge(bridgeSize));
        return bridge;
    }

    public int askBridgeSize() {
        int bridgeSize = viewService.requestBridgeSize();
        return bridgeSize;
    }

    public List<String> makeBridge(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return bridge;
    }
}
