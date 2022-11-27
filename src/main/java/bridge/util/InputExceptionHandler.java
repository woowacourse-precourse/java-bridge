package bridge.util;

import bridge.view.InputView;
import bridge.view.OutputView;

public class InputExceptionHandler {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public int getBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
                return getBridgeSize();
            }
        }
    }

    public String getMoving() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
                return getMoving();
            }
        }
    }

    public String getGameCommand() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
                return getGameCommand();
            }
        }
    }

}

