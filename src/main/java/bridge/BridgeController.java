package bridge;

import bridge.domain.Bridge;
import bridge.view.InputView;
import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public BridgeController(BridgeNumberGenerator bridgeNumberGenerator) {
        this.inputView = new InputView();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    private Bridge createBridge() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeShapeValues = bridgeMaker.makeBridge(bridgeSize);
        return Bridge.createByBridgeShapeValue(bridgeShapeValues);
    }
}
