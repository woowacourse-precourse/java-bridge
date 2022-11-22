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
        return new Bridge(makeBridge(bridgeSize));
    }

    public int askBridgeSize() {
        return viewService.requestBridgeSize();
    }

    public List<String> makeBridge(int bridgeSize){
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
