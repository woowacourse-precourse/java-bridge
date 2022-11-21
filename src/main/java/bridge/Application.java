package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView(bridgeGame);

        BridgeGameManager bridgeGameManager = new BridgeGameManager(bridgeMaker, bridgeGame, inputView, outputView);

        bridgeGameManager.start();
    }
}
