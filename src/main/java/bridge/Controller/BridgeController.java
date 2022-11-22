package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.Bridge;
import bridge.View.InputView;

import java.util.List;

public class BridgeController {
    public Bridge generate() {
        Bridge bridge = createBridge();

        return bridge;
    }

    public Bridge createBridge() {
        InputView inputView = new InputView();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        int bridgeSize = inputView.readBridgeSize();
        List<String> shape = bridgeMaker.makeBridge(bridgeSize);

        Bridge bridge = new Bridge(shape);

        return bridge;
    }
}
