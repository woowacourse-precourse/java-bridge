package bridge;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public Controller(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public void start() {
        outputView.printBridgeGameStart();
        int bridgeSize = inputView.readBridgeSize(outputView::printBridgeSizeInput);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }
}
