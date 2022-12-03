package bridge.controller;

import bridge.domain.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InputController {
    private InputView inputView;
    private OutputView outputView;

    public InputController() {
        inputView = new InputView(new Validator());
        outputView = new OutputView();
    }

    public int suggestBridgeSize() {
        while (true) {
            try {
                outputView.printBridgeSize();
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    public String suggestMoving() {
        while (true) {
            try {
                outputView.printMove();
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }

    public String suggestGameCommand() {
        while (true) {
            try {
                outputView.printRetry();
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }
}
