package bridge.Controller;

import bridge.View.InputView;
import bridge.View.OutputView;

public class ViewController {

    private final InputView input;
    private final OutputView output;

    ViewController() {
        input = new InputView();
        output = new OutputView();
    }

    public int startAndGetBridgeSize() {
        output.printStart();
        return getBridgeSize();
    }

    private int getBridgeSize() {
        try {
            output.printGetBridgeSize();
            return input.readBridgeSize();
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return getBridgeSize();
        }
    }

}
