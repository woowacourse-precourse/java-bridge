package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private static boolean gameStatus = true;
    public void run() {
        int bridgeSize = InputView.readBridgeSize();
        BridgeGame bridgeGame = getBridgeGame(bridgeSize);
        for (int bridgeIndex = 0; bridgeIndex < bridgeSize; bridgeIndex++) {
            String moveSide = inputMoveSide(bridgeIndex);
            if (checkMoveSide(bridgeGame, bridgeIndex, moveSide)) continue;
            if (gameStatus(gameStatus, bridgeGame, bridgeIndex)) break;
            bridgeIndex = backToPreviousIndex(bridgeIndex);
        }
        OutputView.printBridgeResult(gameStatus, bridgeGame.getTryCount());
    }

    private static int backToPreviousIndex(int bridgeIndex) {
        bridgeIndex--;
        return bridgeIndex;
    }

    private BridgeGame getBridgeGame(int bridgeSize) {
        int tryCount = 1;
        List<String> bridgeMakeResult = generateBridge(bridgeSize);
        return new BridgeGame(bridgeMakeResult, tryCount);
    }
    
    private static boolean checkMoveSide(BridgeGame bridgeGame, int bridgeIndex, String moveSide) {
        if (isMoveSuccessfulOrNot(bridgeGame, bridgeIndex, moveSide)) return true;
        gameStatus = bridgeGame.retry();
        return false;
    }

    private static String inputMoveSide(int bridgeIndex) {
        OutputView.replaceCloseBracket(bridgeIndex);
        return InputView.inputMoving();
    }

    private static boolean isMoveSuccessfulOrNot(BridgeGame bridgeGame, int bridgeIndex, String moveSide) {
        if (bridgeGame.move(moveSide, bridgeIndex)) {
            OutputView.moveSuccess(moveSide, bridgeIndex);
            return true;
        }
        if (!bridgeGame.move(moveSide, bridgeIndex)) {
            OutputView.moveFail(moveSide, bridgeIndex);
        }
        return false;
    }

    private static boolean gameStatus(boolean gameResult, BridgeGame bridgeGame, int bridgeIndex) {
        if (gameResult) {
            bridgeGame.addTryCount();
            OutputView.goBackBeforeOneStep(bridgeIndex);
        }
        return !gameResult;
    }

    private List<String> generateBridge(int size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        return bridgeMaker.makeBridge(size);
    }
}
