package bridge.ui;

public class Exception {
    private final OutputView outputView = new OutputView();

    public Boolean exceptionBridgeSize() {
        outputView.printErrorBridgeSize();
        return false;
    }

    public Boolean exceptionMoving() {
        outputView.printErrorMoving();
        return false;
    }

    public Boolean exceptionGameCommand() {
        outputView.printErrorGameCommand();
        return false;
    }
}
