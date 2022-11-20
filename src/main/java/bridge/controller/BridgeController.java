package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeSize;
import bridge.domain.Move;
import bridge.view.InputView;

public class BridgeController {

    InputView inputView = new InputView();
    BridgeSize bridge = new BridgeSize();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    Move mm = new Move();

    public void start() {
        String size = inputView.readBridgeSize();
        bridge.isNumber(size);
        bridge.isRangeNumber(size);
        int s = Integer.parseInt(size);
        bridgeMaker.makeBridge(s);
        String move = inputView.readMoving();
        mm.isProper(move);

    }

}
