package bridge.Controller;

import bridge.View.InputView;
import bridge.View.OutputView;

public class ViewController {

    private final InputView input;
    private final OutputView output;

    public ViewController() {
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

    public String getMoving() {
        try {
            output.printGetMoving();
            return input.readMoving();
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return getMoving();
        }
    }

    public String getCommand() {
        try {
            output.printGetGameCommand();
            return input.readGameCommand();
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return getCommand();
        }
    }

    public void printResult(String result) {
        output.printMap(result);
    }

    public void quit(String result, boolean isSuccess, int playCount) {
        output.printResult(result, isSuccess, playCount);
    }
}
