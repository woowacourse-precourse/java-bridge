package bridge.controller;

import bridge.domain.Bridge;
import bridge.BridgeGame;
import bridge.domain.BridgeResult;
import bridge.domain.GameCommand;
import bridge.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    public BridgeGameController() {
        activate();
    }

    private void activate() {
        try {
            playBridgeGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void playBridgeGame() {
        Bridge bridge = InputController.inputBridgeSize();
        List<BridgeResult> bridgeResults = new ArrayList<>();
        startBridgeGame(bridgeResults, bridge);
    }

    private void startBridgeGame(List<BridgeResult> bridgeResults, Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridgeResults, bridge);
        while (bridge.notOverStep() && bridgeGame.notExit()) {
            bridgeGame.move();
            OutputView.printMap(bridgeGame.getBridgeResults());
            testBridgeGame(bridgeGame);
            bridge.goToNextStep();
        }
        OutputView.printResult(bridgeGame, bridgeGame.getBridgeResults());
    }

    private void testBridgeGame(BridgeGame bridgeGame) {
        if (bridgeGame.isFailedGame()) {
            GameCommand gameCommand = InputController.inputGameCommand();
            gameCommand.isRetryGame(bridgeGame);
        }
    }

}
