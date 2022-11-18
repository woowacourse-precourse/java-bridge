package bridge.ui;

public class Exception {
    private final OutputView outputView = new OutputView();

    public void exceptionBridgeSize() {
        outputView.printErrorBridgeSize();
        throw new IllegalArgumentException();
    }
}
