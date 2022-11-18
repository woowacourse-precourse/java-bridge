package bridge.view;

import bridge.BridgeMaker;

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
        try {
            bridgeMaker.makeBridge(inputView.readBridgeSize());
        } catch (IllegalArgumentException exception) {
            outputView.printError(exception.getMessage());
            this.receiveClientRequest();
        }
    }

}
