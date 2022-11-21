package bridge.controller;

import bridge.core.BridgeGame;
import bridge.type.FinishCondition;
import bridge.type.ProcessCondition;
import bridge.view.OutputView;

public class BridgeGameController {

    public void playBridgeGame() {
        BridgeGame bridgeGame = BridgeGameHandler.initGame();
        ProcessCondition startCondition = bridgeGame.start();
        ProcessCondition endCondition = BridgeGameHandler.executeGame(startCondition, bridgeGame);
        if (endCondition == FinishCondition.FINISHED) OutputView.printResult(FinishCondition.FINISHED, bridgeGame);
        if (endCondition == FinishCondition.NOT_FINISHED) OutputView.printResult(FinishCondition.NOT_FINISHED, bridgeGame);
    }
}
