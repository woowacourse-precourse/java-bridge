package bridge;

public class BridgeView {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeView(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void gameStartMessage() {
        outputView.gameStartMessage();
    }

    public int inputBridgeSizeMessage() {
        outputView.inputBridgeSizeMessage();
        return inputView.readBridgeSize();
    }

    public String inputMoveCommandMessage() {
        outputView.inputMoveCommandMessage();
        return inputView.readMoving();
    }

    public String inputRetryCommandMessage() {
        outputView.inputRetryCommandMessage();
        return inputView.readGameCommand();
    }
}
