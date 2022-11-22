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
        boolean canMove;
        do {
            outputView.printMovingMsg();
            canMove = canMove();
            outputView.printMap(bridgeGame.getBridgeGameResult());
        } while (canMove);
    }

    private boolean canMove() {
        while (true) {
            try {
                return bridgeGame.move(inputView.readMoving());
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }

    private boolean isRetrying() {
        while (true) {
            try {
                return bridgeGame.retry(inputView.readGameCommand());
            } catch (IllegalArgumentException e) {
                outputView.print(e.getMessage());
            }
        }
    }
}
