package bridge.controller;

import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    private int inputBridgeSize() {
        outputView.printInputBridgeSize();
        return inputView.readBridgeSize();
    }

    private String inputMoving() {
        outputView.printInputMoving();
        return inputView.readMoving();
    }

    private String inputCommand() {
        outputView.printInputCommand();
        return inputView.readGameCommand();
    }
}
