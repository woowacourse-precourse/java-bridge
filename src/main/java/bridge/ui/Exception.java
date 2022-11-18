package bridge.ui;

public class Exception {
    private final OutputView outputView = new OutputView();

    public Boolean exceptionBridgeSize() {
        outputView.printErrorBridgeSize();
        return false;
    }
}
