package bridge.controller;

import bridge.core.BridgeGame;
import bridge.type.FinishCondition;
import bridge.type.ProcessCondition;
import bridge.view.OutputView;

import static bridge.view.InputView.*;

public class BridgeGameController {

    public void playBridgeGame() {
        BridgeGame bridgeGame = BridgeGame.initBridgeGame(readBridgeLength());
        ProcessCondition startCondition = bridgeGame.start();
        ProcessCondition endCondition = BridgeGameHandler.executeGame(startCondition, bridgeGame);
        if (endCondition == FinishCondition.FINISHED) OutputView.printResult(FinishCondition.FINISHED, bridgeGame);
        if (endCondition == FinishCondition.NOT_FINISHED) OutputView.printResult(FinishCondition.NOT_FINISHED, bridgeGame);
    }
}
