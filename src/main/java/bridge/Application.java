package bridge;

import bridge.controller.BridgeController;
import bridge.model.BridgeGame;
import bridge.view.BridgeView;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker);
        BridgeView bridgeView = new BridgeView(new InputView(), new OutputView());
        BridgeController bridgeController = new BridgeController(bridgeGame, bridgeView);
        bridgeController.start();
    }
}
