package bridge;

import bridge.controller.Controller;
import bridge.domain.BridgeGame;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BridgeGame bridgeGame = Controller.startGame();
        do {
            OutputView outputView = new OutputView();
            Controller.startRound(bridgeGame, outputView);
            if (!bridgeGame.isGameContinue()) {
                Controller.restartOrQuitGame(bridgeGame, outputView);
            }
            Controller.restartOrQuitGame(bridgeGame, outputView);
        } while (bridgeGame.isGameContinue());
    }
}
