package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.View.InputView;

public class GameManager {
    public void runGame() {
        makeBridgeGame();
    }

    public void makeBridgeGame() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        InputView inputView = new InputView();
        bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
}
