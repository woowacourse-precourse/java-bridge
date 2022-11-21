package bridge.view;

import bridge.controller.BridgeController;

public class DefaultView implements View {

    private final OutputView outputView;
    private final InputView inputView;
    private final BridgeController controller;

    public DefaultView(
            OutputView outputView,
            InputView inputView,
            BridgeController controller) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.controller = controller;
    }

    public void render() {
        outputWelcome();
        inputBridgeSize();
    }

    private void outputWelcome() {
        outputView.printWelcome();
        System.out.println();
    }

    private void inputBridgeSize() {
        outputView.printReadBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        controller.createBridge(bridgeSize);
    }

}
