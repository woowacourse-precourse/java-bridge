package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;

public class BridgeController {
    private BridgeGame bridgeGame;
    private InputView inputView;
    private BridgeMaker bridgeMaker;
    void run(){
        inputView.readBridgeSize();
        bridgeGame.move();
    }
}
