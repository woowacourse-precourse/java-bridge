package controller;

import bridge.BridgeGame;
import constants.Message;
import constants.Result;
import view.InputView;
import view.OutputView;

public class BridgeGameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final BridgeGame bridgeGame;
    private boolean choice = true;
    private int totalTry = 1;

    public BridgeGameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void play() {
        outputView.printMessage(Message.START_GAME);
        generateBridge();
        start();
        outputView.printResult(bridgeGame.getResult(), Result.valueToStatus(bridgeGame.isWin()), totalTry);
    }

    private void start() {
        while (choice) {
            crossBridge();

            if (bridgeGame.isWin()) {
                break;
            }
            retryOrEnd();
        }
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
        try {
            outputView.printMessage(Message.REQUEST_MOVE_DIRECTION);
            bridgeGame.move(inputView.readMoving());
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            move();
        }
    }

    private void crossBridge() {
        while (bridgeGame.canMove() && !bridgeGame.isWin()) {
            move();
            bridgeGame.saveResult();
            outputView.printMap(bridgeGame.getResult());
        }
    }

    private void getCommand() {
        try {
            outputView.printMessage(Message.REQUEST_RETRY_OR_END);
            choice = bridgeGame.retryOrEnd(inputView.readGameCommand());
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            getCommand();
        }
    }

    private void retryOrEnd() {
        getCommand();

        if (choice) {
            bridgeGame.retry();
            totalTry++;
        }
    }
}
