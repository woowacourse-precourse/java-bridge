package bridge;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printBridgeGameStart();
        int bridgeSize = inputView.readBridgeSize(outputView::printBridgeSizeInput);
    }
}
