package bridge;

import bridge.models.BridgeGame;
import bridge.views.OutputView;

public class Application {
    public static void main(String[] args) {
        BridgeGame bridgeGame = Controller.startGame();
        do {
            OutputView outputView = new OutputView();
            Controller.startRound(bridgeGame, outputView);
            if (bridgeGame.isGameSuccess()) {
                outputView.printResult(bridgeGame);
                break;
            }
            Controller.restartGame(bridgeGame, outputView);
        } while (bridgeGame.isGameContinue());
    }
}
