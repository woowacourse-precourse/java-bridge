package bridge.util;

import bridge.view.InputView;
import bridge.view.OutputView;

public class InputExceptionHandler {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public int getBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return inputView.readBridgeSize();
        }
    }

    public String getMoving() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return inputView.readMoving();
        }
    }

    public String getGameCommand() {
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return inputView.readGameCommand();
        }
    }

}

