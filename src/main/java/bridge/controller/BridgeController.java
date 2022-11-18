package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.view.InputView;

public class BridgeController {

    InputView inputView = new InputView();
    Bridge bridge = new Bridge();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void start() {
        String size = inputView.readBridgeSize();
        bridge.isNumber(size);
        bridge.isRangeNumber(size);
        int s = Integer.parseInt(size);
        bridgeMaker.makeBridge(s);
        String move = inputView.readMoving();

    }

}
