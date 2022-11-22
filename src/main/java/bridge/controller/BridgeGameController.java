package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    public BridgeGameController() {
        playGame();
    }

    public void playGame() {
        Bridge bridge = startGame();

        runGame(bridge);
    }

    public Bridge startGame() {
        Bridge bridge = InputController.getBridge();
        return bridge;
    }


    public static void runGame(Bridge bridge) {
        List<MoveResult> moveResults = new ArrayList<>();
        BridgeGame bridgeGame = new BridgeGame(moveResults, bridge);
        while (bridge.crossingBridgeSuccess() && bridgeGame.notExit()) {
            abilityToMove(bridgeGame);
            if (retryOrOver(bridgeGame)) {
                moveResults = new ArrayList<>();
                continue;
            }
            bridge.nextStep();
        }
        gameOver(bridgeGame, moveResults);
    }

    private static void abilityToMove(BridgeGame bridgeGame) {
        bridgeGame.move();
        OutputView.printMap(bridgeGame.getMoveResults());
    }

    private static boolean retryOrOver(BridgeGame bridgeGame) {
        if (bridgeGame.isFailedGame()) {
            boolean command = InputController.retryOrGameOver();
            if (command) {
                bridgeGame.retry();
                return true;
            }
            bridgeGame.exit();
        }
        return false;
    }

    private static void gameOver(BridgeGame bridgeGame, List<MoveResult> moveResults) {
        OutputView.printResult(bridgeGame, moveResults);
    }

}
