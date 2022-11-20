package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final String RESTART = "R";

    private final BridgeGame bridgeGame;

    public BridgeGameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void process() {
        initiation();
        playGame();
    }

    private void initiation() {
        OutputView.printStartMessage();
        OutputView.printBlankLine();
        setBridgeSize();
        bridgeGame.setCurrentRoute();
    }

    private void setBridgeSize() {
        OutputView.printBridgeSizeInputMessage();
        int bridgeSize = InputView.readBridgeSize();
        OutputView.printBlankLine();
        bridgeGame.setBridge(bridgeSize);
    }

    private void playGame() {
        takeTrial();
        if (isFinish()) {
            return;
        }
        retryGame();
    }

    private void retryGame() {
        while (InputView.readGameCommand().equals(RESTART)) {
            bridgeGame.retry();
            takeTrial();
            if (isFinish()) {
                return;
            }
        }
    }

    private void takeTrial() {
        do {
            if (isFinish()) {
                return;
            }
            takeTurn();
        } while (bridgeGame.isMovementSuccess());
    }

    private void takeTurn() {
        OutputView.printNextMovementInputMessage();
        String nextMovement = InputView.readMoving();
        bridgeGame.move(nextMovement);
    }

    private boolean isFinish() {
        return bridgeGame.isLastSquare();
    }
}
