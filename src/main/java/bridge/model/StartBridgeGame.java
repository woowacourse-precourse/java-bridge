package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;

public class StartBridgeGame {
    public BridgeGame start(BridgeMaker bridgeMaker, InputView inputView) {
       return new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }
}
