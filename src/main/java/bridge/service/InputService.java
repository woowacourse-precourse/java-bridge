package bridge.service;

import bridge.view.InputView;
import bridge.view.OutputView;

public class InputService {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public int requestBridgeSize() {
        try {
            outputView.printRequestBridgeSize();
            int bridgeSize = inputView.readBridgeSize();
            return bridgeSize;
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return requestBridgeSize();
        }
    }

    public String requestMove() {
        try {
            outputView.printRequestMove();
            String moveDirection = inputView.readMoving();
            return moveDirection;
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return requestMove();
        }
    }

    public String requestStatusOfGame() {
        try {
            outputView.printRequestRestart();
            String command = inputView.readGameCommand();
            return command;
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            return requestStatusOfGame();
        }
    }
}