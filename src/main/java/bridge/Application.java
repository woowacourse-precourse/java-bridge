package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeService bridgeService = new BridgeServiceImpl(bridgeMaker);
        BridgeController bridgeController = new BridgeController(inputView, outputView, bridgeService);
        BridgeGame bridgeGame = new BridgeGame(bridgeController);

        bridgeGame.runGame();
    }
}
