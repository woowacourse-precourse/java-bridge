package bridge.view;

public class BridgeGameView {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int requestNewBridgeSize() {
        outputView.printStartPrompt();

        return inputView.readBridgeSize();
    }

    public String requestDirection() {
        outputView.printInputDirectionPrompt();

        return inputView.readMoving();
    }
}
