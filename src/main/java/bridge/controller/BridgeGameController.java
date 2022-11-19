package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

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
        bridgeGame.setLocation();
    }

    private void setBridgeSize() {
        OutputView.printBridgeSizeInputMessage();
        int bridgeSize = InputView.readBridgeSize();
        OutputView.printBlankLine();
        bridgeGame.setBridge(bridgeSize);
    }

    private void playGame() {
        takeTrial();
        while (InputView.readGameCommand().equals(RESTART)) {
            bridgeGame.retry();
            takeTrial();
            if (isFinish()) {
                return;
            }
        }
    }

    private void takeTrial() {
        String movement;
        do {
            if (isFinish()) {
                return;
            }
            movement = getMovement();
        } while (bridgeGame.isMovementSuccess(movement));
    }

    private String getMovement() {
        OutputView.printNextMovementInputMessage();
        String nextMovement = InputView.readMoving();
        bridgeGame.move();
        return nextMovement;
    }

    private boolean isFinish() {
        return bridgeGame.isLastSquare();
    }

    private void setMap(List) {

    }
}
