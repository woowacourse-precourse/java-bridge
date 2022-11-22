package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private static final int BRIDGE_FIRST_INDEX = 0;
    private static final int DEFAULT_TRY_COUNT = 1;
    private static boolean gameStatus = true;

    public void runGame() {
        OutputView.printGameStartMessage();
        OutputView.printInputBridgeSizeMessage();
        int bridgeSize = InputView.readBridgeSize();
        BridgeGame bridgeGame = createBridgeGame(bridgeSize);
        playGame(bridgeSize, bridgeGame);
        OutputView.printBridgeResult(gameStatus, bridgeGame.getTryCount());
    }

    private static void playGame(int bridgeSize, BridgeGame bridgeGame) {
        for (int bridgeIndex = BRIDGE_FIRST_INDEX; bridgeIndex < bridgeSize; bridgeIndex++) {
            String moveSide = inputMoveSide(bridgeIndex);
            if (checkMoveSide(bridgeGame, bridgeIndex, moveSide)) continue;
            if (gameStatus(gameStatus, bridgeGame, bridgeIndex)) break;
            bridgeIndex = backToPreviousIndex(bridgeIndex);
        }
    }

    private BridgeGame createBridgeGame(int bridgeSize) {
        List<String> bridgeMakeResult = generateBridge(bridgeSize);
        return new BridgeGame(bridgeMakeResult, DEFAULT_TRY_COUNT);
    }

    private List<String> generateBridge(int size) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        return bridgeMaker.makeBridge(size);
    }

    private static String inputMoveSide(int bridgeIndex) {
        OutputView.replaceCloseBracket(bridgeIndex);
        return InputView.inputMoving();
    }

    private static boolean gameStatus(boolean gameResult, BridgeGame bridgeGame, int bridgeIndex) {
        if (gameResult) {
            bridgeGame.addTryCount();
            OutputView.goBackBeforeOneStep(bridgeIndex);
        }
        return !gameResult;
    }

    private static boolean checkMoveSide(BridgeGame bridgeGame, int bridgeIndex, String moveSide) {
        if (isMoveSuccessfulOrNot(bridgeGame, bridgeIndex, moveSide)) return true;
        gameStatus = bridgeGame.retry();
        return false;
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

    private static int backToPreviousIndex(int bridgeIndex) {
        bridgeIndex--;
        return bridgeIndex;
    }
}
