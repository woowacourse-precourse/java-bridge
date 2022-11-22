package bridge.controller;

import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void play() {
        start();
        do {
            moveBridge();
        } while (isPlaying());
        end();
    }

    private boolean isPlaying() {
        if (bridgeGame.isSuccess()) {
            return false;
        }
        return isRetrying();
    }

    private void start() {
        outputView.printGameStartMsg();
        makeBridge();
        bridgeGame.start();
        isPlaying = true;
    }

    private void end() {
        outputView.printResult(bridgeGame.getBridgeGameResult());
    }

    private void makeBridge() {
        outputView.printBridgeSizeMsg();
        while (true) {
            try {
                bridgeGame.make(inputView.readBridgeSize());
                return;
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    private void moveBridge() {
        boolean canMove = true;
        int moveCount = 0;
        while (canMove && bridgeGame.hasBridgeToMove(moveCount)) {
            outputView.printMovingMsg();
            canMove = bridgeGame.move(moveCount, inputView.readMoving());
            outputView.printMap(bridgeGame.getBridgeGameResult());
            moveCount++;
        }
        judge(canMove);
    }

    private void judge(boolean canMove) {
        if (canMove) {
            succeed();
            return;
        }
        fail();
    }

    private void succeed() {
        bridgeGame.succeed();
        isPlaying = false;
    }

    private void fail() {
        outputView.printGameCommandMsg();
        if (bridgeGame.doesRetry(inputView.readGameCommand())) {
            bridgeGame.retry();
            return;
        }
        isPlaying = false;
    }
}
