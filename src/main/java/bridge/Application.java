package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeOfSizeMaker bridgeOfSizeMaker = new BridgeOfSizeMaker();
        List<String> bridge = bridgeOfSizeMaker.makeBridgeOfSize();
        BridgeGame bridgeGame = new BridgeGame(bridge);
        GameController gameController = new GameController(bridgeGame);
        OutputView outputView = new OutputView();

        do {
            gameController.executeMoving();
        } while (gameController.doesPlayerWantRetrial && bridgeGame.getPlayerLocation() < bridgeGame.getBridge().size()-1);
        outputView.printResult(bridgeGame.getTrial(), bridgeGame.getPlayerLocation(), bridgeGame.getBridge());
    }
}
