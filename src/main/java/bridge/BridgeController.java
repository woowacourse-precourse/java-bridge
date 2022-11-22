package bridge;

import java.util.List;

public class BridgeController {

    public void run(InputView inputView, int bridgeSize, List<String> randomBridge) {
        BridgeIndex index = new BridgeIndex(); //
        int gameCount = 1;
        boolean gameEndButton = false;
        BridgeResults bridgeResults = new BridgeResults();
        BridgeGame bridgeGame = new BridgeGame(randomBridge, bridgeResults);
        OutputView outputView = new OutputView(); //
        while (!index.endGame(bridgeSize) && !gameEndButton) {
            boolean compareBridgeLocationResult = bridgeGame.move(inputView.readMoving(), bridgeResults, index);
            outputView.printMap(bridgeResults);
        }
    }
}
