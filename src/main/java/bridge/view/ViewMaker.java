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
            this.bridgeMaker.makeBridge(this.inputView.readBridgeSize());
        } catch (IllegalArgumentException exception) {
            this.outputView.printError(exception.getMessage());
            this.receiveClientRequest();
        }
    }

    public void receiveUserDirection(int bridgeLocation) {
        try {
            this.outputView.printMap(
                    bridgeMaker.compareToStoredBridgeBlueprint(inputView.readDirection(), bridgeLocation));

        } catch (IllegalArgumentException exception) {
            this.outputView.printError(exception.getMessage());
            this.receiveUserDirection(bridgeLocation);
        }
    }

}
