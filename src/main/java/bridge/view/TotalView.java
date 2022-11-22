package bridge.view;

public class TotalView {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public InputView in() {
        return inputView;
    }

    public OutputView out() {
        return outputView;
    }
}
