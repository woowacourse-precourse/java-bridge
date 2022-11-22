package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeOfSizeMaker bridgeOfSizeMaker = new BridgeOfSizeMaker();
        List<String> bridge = bridgeOfSizeMaker.makeBridgeOfSize();
        BridgeGame bridgeGame = new BridgeGame(bridge);
        GameController gameController = new GameController(bridgeGame);
        OutputView outputView = new OutputView();

        gameController.runGame();
        outputView.printResult(bridgeGame.getBridge(), bridgeGame.getPlayerLocation(),
                gameController.getIsMovingAvailable());
        outputView.printTrialNumber(bridgeGame.getTrialCount());
    }
}
