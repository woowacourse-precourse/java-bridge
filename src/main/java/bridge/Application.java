package bridge;

import bridge.controller.BridgeController;
import bridge.model.BridgeGame;
import bridge.view.ConsolidatedView;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        ConsolidatedView consolidatedView = new ConsolidatedView(new InputView(), new OutputView());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker);
        BridgeController bridgeController = new BridgeController(consolidatedView, bridgeGame);
        bridgeController.startGame();
    }
}
