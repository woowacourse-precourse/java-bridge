package bridge.view;

public class BridgeGameView {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

}



