package controller;

import bridge.BridgeGame;
import view.InputView;
import view.OutputView;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame;

    public BridgeGameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void startGame() {
        outputView.printMessage(Message.START_GAME);
        generateBridge();
    }

    private void generateBridge() {
        try {
            outputView.printMessage(Message.REQUEST_BRIDGE_SIZE);
            bridgeGame.generateBridge(inputView.readBridgeSize());
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            generateBridge();
        }
    }

    private void move() {
        String direction = inputView.readMoving();
        bridgeGame.move(direction);
    }

}
