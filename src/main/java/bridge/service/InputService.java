package bridge.service;

import bridge.view.InputView;
import bridge.view.OutputView;

public class InputService {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public int requestBridgeSize() {
        outputView.printRequestBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        return bridgeSize;
    }

    public String requestMove() {
        outputView.printRequestMove();
        String moveDirection = inputView.readMoving();
        return moveDirection;
    }

    public String requestStatusOfGame() {
        outputView.printRequestRestart();
        String command = inputView.readGameCommand();
        return command;
    }
}