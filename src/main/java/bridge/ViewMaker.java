package bridge;

public class ViewMaker {
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    public ViewMaker(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void receiveClientRequest() {
        bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

}
