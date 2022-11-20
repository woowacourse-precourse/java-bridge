package bridge.controller;

import bridge.core.BridgeGame;
import bridge.type.FinishCondition;
import bridge.type.ProcessCondition;

import static bridge.view.InputView.*;

public class BridgeGameController {

    public void playBridgeGame() {
        BridgeGame bridgeGame = BridgeGame.initBridgeGame(readBridgeLength());
        ProcessCondition startCondition = bridgeGame.start();
        ProcessCondition endCondition = BridgeGameHandler.executeGame(startCondition, bridgeGame);
        if (endCondition == FinishCondition.FINISHED) {
            // TODO : OutputView 다리 건너기 성공 결과 출력
        }
        if (endCondition == FinishCondition.NOT_FINISHED) {
            // TODO : OutputView 다리 건너기 실패 결과 출력
        }
    }
}
