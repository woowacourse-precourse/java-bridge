package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final String RESTART = "R";

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void process() {
        initiation();
        inGame();
    }

    private void initiation() {
        outputView.printStartMessage();
        outputView.printBlankLine();
        setBridgeSize();
        bridgeGame.setLocation();
    }

    private void setBridgeSize() {
        outputView.printBridgeSizeInputMessage();
        int bridgeSize = inputView.readBridgeSize();
        outputView.printBlankLine();
        bridgeGame.setBridge(bridgeSize);
    }

    private void inGame() {
        takeTrial();
        while (inputView.readGameCommand().equals(RESTART)) {
            bridgeGame.retry();
            takeTrial();
        }
    }

    private void takeTrial() {
        String movement;
        do {
            movement = getMovement();
        } while (bridgeGame.isMovementSuccess(movement));
    }

    private String getMovement() {
        outputView.printNextMovementInputMessage();
        String nextMovement = inputView.readMoving();
        bridgeGame.move();
        return nextMovement;
    }
}
