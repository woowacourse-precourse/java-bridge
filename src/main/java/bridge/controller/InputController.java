package bridge.controller;

import bridge.view.ErrorOutputView;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InputController {
    private InputView inputView;
    private OutputView outputView;
    private ErrorOutputView errorOutputView;

    public InputController(InputView inputView, OutputView outputView, ErrorOutputView errorOutputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.errorOutputView = errorOutputView;
    }

    public int suggestBridgeSize() {
        while (true) {
            try {
                outputView.printBridgeSize();
                int bridgeSize = inputView.readBridgeSize();
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                errorOutputView.printBridSizeError();
            }
        }
    }

    public String suggestMoving() {
        while (true) {
            try {
                outputView.printMove();
                String moving = inputView.readMoving();
                return moving;
            } catch (IllegalArgumentException e) {
                errorOutputView.printMoveError();
            }
        }
    }

    public String suggestGameCommand() {
        while (true) {
            try {
                outputView.printRetry();
                String retry = inputView.readGameCommand();
                return retry;
            } catch (IllegalArgumentException e) {
                errorOutputView.printRetryError();
            }
        }
    }
}
