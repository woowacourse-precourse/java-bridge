package bridge.bridge;

import bridge.config.BridgeStatus;
import bridge.view.InputView;

import java.util.List;

public class BridgeController {

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final InputView inputView = new InputView();

    public Bridge createBridge() {
        Bridge bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        return bridge;
    }

}
