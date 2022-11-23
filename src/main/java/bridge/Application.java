package bridge;

import bridge.cache.BridgeStatusSaver;
import bridge.controller.BridgeController;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private static BridgeController bridgeController;

    public static void main(String[] args) {
        dependencyInjection();
        bridgeController.run();
    }

    private static void dependencyInjection() {
        BridgeStatusSaver bridgeStatusSaver = new BridgeStatusSaver();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, bridgeStatusSaver);
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        bridgeController = new BridgeController(bridgeGame, inputView, outputView);
    }
}
