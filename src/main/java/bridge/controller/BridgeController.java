package bridge.controller;

import bridge.domain.Bridge;
import bridge.view.InputView;

public class BridgeController {

    InputView inputView = new InputView();
    Bridge bridge = new Bridge();

    public void start() {
        String size = inputView.readBridgeSize();
        bridge.isNumber(size);
        bridge.isRangeNumber(size);
    }

}
