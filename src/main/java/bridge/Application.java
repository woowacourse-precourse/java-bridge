package bridge;

import bridge.controller.BridgeController;
import bridge.domain.BridgeGame;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BridgeGame bridgeGame = BridgeController.startGame();
        do {
            OutputView outputView = new OutputView();
            BridgeController.startRound(bridgeGame, outputView);
            if (!bridgeGame.isGameContinue()) {
                BridgeController.restartOrQuitGame(bridgeGame, outputView);
            }
            BridgeController.restartOrQuitGame(bridgeGame, outputView);
        } while (bridgeGame.isGameContinue());
    }
}
