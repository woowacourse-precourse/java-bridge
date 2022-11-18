package bridge.Controller;

import bridge.Model.Bridge;
import bridge.View.InputView;

public class BridgeController {
    public Bridge generate() {
        Bridge bridge = createBridge();

        return bridge;
    }

    public Bridge createBridge() {
        InputView inputView = new InputView();

        int bridgeSize = inputView.readBridgeSize();
        

        return new Bridge();
    }
}
