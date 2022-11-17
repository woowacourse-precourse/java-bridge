package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.bridgemaker.BridgeMaker;
import java.util.List;

public class BridgeService {

    private BridgeMaker bridgeMaker;

    public BridgeService(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public Bridge generateBridge(int size) {
        List<String> squares = bridgeMaker.makeBridge(size);
        return new Bridge(squares);
    }
}
