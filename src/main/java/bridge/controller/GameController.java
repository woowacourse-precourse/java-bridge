package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    private BridgeGame bridgeGame = new BridgeGame();

    private void startGame() {

        do {
            playRound();
            if (isFail()) break;
        } while (isFinalRound());
    }

    private void createBridge(int bridgeSize) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> randomBridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.createBridge(randomBridge);
    }

    private String loadMoveDirection() {
        return InputView.readMoving();
    }

    private void playRound() {
        String moveDirection = loadMoveDirection();
        List<List<String>> bridgeRecord = bridgeGame.getRecordByMove(moveDirection);
        OutputView.printMap(bridgeRecord);
    }

    private boolean isFail() {
        if (bridgeGame.isPass()) {
            return false;
        }
        return isRestartOrQuit();
    }

    private boolean isRestartOrQuit() {
        String gameCommand = InputView.readGameCommand();
        if (bridgeGame.isGameRestart(gameCommand)) {
            bridgeGame.retry();
            startGame();
            return false;
        }
        return true;
    }

    private boolean isFinalRound() {
        return bridgeGame.isRoundLeft();
    }
}