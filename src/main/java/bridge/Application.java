package bridge;

import bridge.controller.BridgeController;
import bridge.model.BridgeGame;
import bridge.model.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BridgeGame bridgeGame = new BridgeGame(getBridgeMaker(), new Result());
        BridgeController bridgeController = new BridgeController(new InputView(), new OutputView(), bridgeGame);
        bridgeController.initBridgeController();
        bridgeController.startGame();

    }

    public static BridgeMaker getBridgeMaker() {
        return new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
