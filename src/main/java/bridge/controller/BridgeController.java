package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.GameCommandFlag;
import bridge.model.ResultFlag;
import bridge.view.ConsolidatedView;

public class BridgeController {
    private final ConsolidatedView consolidatedView;
    private final BridgeGame bridgeGame;

    public BridgeController(ConsolidatedView consolidatedView, BridgeGame bridgeGame) {
        this.consolidatedView = consolidatedView;
        this.bridgeGame = bridgeGame;
    }

    public void startGame() {
        consolidatedView.printStartMessage();
        bridgeGame.create(consolidatedView.inputBridgeSize());
        playGame();
        endGame();
    }

    private void playGame() {
        boolean isContinue = true;
        while (isContinue) {
            GameCommandFlag gameCommandFlag = moveBridge();
            if (gameCommandFlag == GameCommandFlag.RETRY) {
                bridgeGame.retry();
            }
            isContinue = isGameContinue(gameCommandFlag);
        }
    }

    private GameCommandFlag moveBridge() {
        bridgeGame.move(consolidatedView.inputMoving());
        consolidatedView.printMoveMap(bridgeGame.getMap());
        if (bridgeGame.getResultFlag() == ResultFlag.FAIL) {
            return consolidatedView.inputGameCommand();
        }
        return GameCommandFlag.NOTHING;
    }

    private boolean isGameContinue(GameCommandFlag gameCommandFlag) {
        if (gameCommandFlag == GameCommandFlag.QUIT) {
            return false;
        }
        if (bridgeGame.completion()) {
            return false;
        }
        return true;
    }

    private void endGame() {
        consolidatedView.printGameResult(bridgeGame.getMap(), bridgeGame.getResultFlag(), bridgeGame.getTryCount());
    }
}
