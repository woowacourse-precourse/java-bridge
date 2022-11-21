package bridge.controller;

import bridge.domain.Validator;
import bridge.view.ErrorOutputView;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InputController {
    private InputView inputView;
    private OutputView outputView;
    private ErrorOutputView errorOutputView;

    public InputController() {
        inputView = new InputView(new Validator());
        outputView = new OutputView();
        errorOutputView = new ErrorOutputView();
    }

    public int suggestBridgeSize() {
        while (true) {
            try {
                outputView.printBridgeSize();
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                errorOutputView.printBridSizeError();
            }
        }
    }

    public String suggestMoving() {
        while (true) {
            try {
                outputView.printMove();
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                errorOutputView.printMoveError();
            }
        }
    }

    public String suggestGameCommand() {
        while (true) {
            try {
                outputView.printRetry();
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                errorOutputView.printRetryError();
            }
        }
    }
}
