package bridge.view.utils;

import bridge.view.InputView;
import bridge.view.OutputView;

public class ConsoleUtils {

    private static InputView inputView;
    private static OutputView outputView;

    static {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public static int inputBridgeSize() {
        return inputView.readBridgeSize();
    }

    public static String inputMoving() {
        return inputView.readMoving();
    }

    public static String inputGameCommand() {
        return inputView.readGameCommand();
    }
}
