package bridge.controller;

import bridge.domain.GameSymbol;
import bridge.domain.ResultSymbol;
import bridge.model.BridgeGame;
import bridge.view.BridgeView;

public class BridgeController {

    private final BridgeGame bridgeGame;
    private final BridgeView bridgeView;

    public BridgeController(BridgeGame bridgeGame, BridgeView bridgeView) {
        this.bridgeGame = bridgeGame;
        this.bridgeView = bridgeView;
    }

    public void start() {
        init();
        loop();
        printResult();
    }

    private void init() {
        bridgeView.gameStartMessage();
        int bridgeSize = bridgeView.inputBridgeSizeMessage();
        bridgeGame.create(bridgeSize);
    }

    private void loop() {
        boolean isContinue = true;
        while (isContinue) {
            GameSymbol gameSymbol = moveBridge();
            if (gameSymbol == GameSymbol.RETRY) {
                bridgeGame.retry();
            }
            isContinue = isGameContinue(gameSymbol);
        }
    }

    private boolean isGameContinue(GameSymbol gameSymbol) {
        if (gameSymbol == GameSymbol.QUIT) {
            return false;
        }
        if (bridgeGame.allTry()) {
            return false;
        }
        return true;
    }

    private GameSymbol moveBridge() {
        bridgeGame.move(bridgeView.inputMoveCommandMessage());
        bridgeView.printMoveResult(bridgeGame.printLines());
        if (bridgeGame.getResultSymbol() == ResultSymbol.FAIL) {
            return bridgeView.inputRetryCommandMessage();
        }
        return GameSymbol.NOTHING;
    }

    private void printResult() {
        bridgeView.printGameResult(bridgeGame.printLines(), bridgeGame.getResultSymbol(), bridgeGame.getGameTryCount());
    }
}
