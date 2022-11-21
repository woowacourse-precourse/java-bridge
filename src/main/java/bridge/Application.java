package bridge;

import bridge.controller.BridgeController;
import bridge.service.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.BridgeView;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeView bridgeView = new BridgeView(new InputView(), new OutputView());
        BridgeController bridgeController = new BridgeController(bridgeView, bridgeMaker);
        bridgeController.gameStart();
    }
}
