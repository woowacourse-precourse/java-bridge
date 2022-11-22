package bridge.controller;

import bridge.core.BridgeGame;
import bridge.type.FinishCondition;
import bridge.type.ProcessCondition;
import bridge.view.OutputView;

public class BridgeGameController {

    public void playBridgeGame() {
        BridgeGameHandler bridgeGameHandler = new BridgeGameHandler();
        BridgeGame bridgeGame = bridgeGameHandler.initGame();
        ProcessCondition startCondition = bridgeGame.start();
        ProcessCondition endCondition = bridgeGameHandler.executeGame(startCondition, bridgeGame);
        if (endCondition == FinishCondition.FINISHED) OutputView.printResult(FinishCondition.FINISHED, bridgeGame);
        if (endCondition == FinishCondition.NOT_FINISHED) OutputView.printResult(FinishCondition.NOT_FINISHED, bridgeGame);
    }
}
