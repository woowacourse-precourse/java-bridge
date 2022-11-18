package bridge.view;

public class TotalView {
    private final InputView in;
    private final OutputView out;

    public TotalView(InputView in, OutputView out) {
        this.in = in;
        this.out = out;
    }

    public InputView in() {
        return in;
    }

    public OutputView out() {
        return out;
    }
}
