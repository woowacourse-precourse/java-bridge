package bridge.controller;
import static bridge.controller.InputController.getBridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    public BridgeGameController() {
        playGame();
    }

    public  void playGame(){
        Bridge bridge = startGame();
        List<MoveResult> moveResults = new ArrayList<>();
        runGame(moveResults, bridge);
    }
    public Bridge startGame() {
        Bridge bridge = InputController.getBridge();
        return bridge;
    }


    public static void runGame(List<MoveResult> moveResults, Bridge bridge) {
        BridgeGame bridgeGame = new BridgeGame(moveResults, bridge);
        while (bridge.crossingBridgeSuccess() && bridgeGame.notExit()) {
            bridgeGame.move();
            OutputView.printMap(bridgeGame.getMoveResults());
//            retryOrOver(bridgeGame);
            bridge.nextStep();
        }
    }


    private static void retryOrOver(BridgeGame bridgeGame) {
        if (bridgeGame.isFailedGame()) {
            bridgeGame.retry();
        }
    }

}
