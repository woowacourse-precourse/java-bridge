package bridge;

import bridge.bo.Bridge;
import bridge.controller.BridgeGameController;
import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        int size = new InputView().readBridgeSize();
        Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size));
        new BridgeGameController(bridge).doGame();
    }
}
