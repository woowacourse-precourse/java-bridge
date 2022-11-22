package bridge;

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
}
