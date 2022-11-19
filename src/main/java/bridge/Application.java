package bridge;

import bridge.service.BridgeGame;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGame bridgeGame = new BridgeGame();
            OutputView.printGameResult();
            bridgeGame.printResult();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
        }
    }
}
