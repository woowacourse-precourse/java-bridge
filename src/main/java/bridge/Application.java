package bridge;

import bridge.command.BridgeSize;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        printTitle();
        final BridgeSize bridgeSize = askBridgeSize();
    }

    private static BridgeSize askBridgeSize() {
        outputView.printBridgeSize();
        return inputView.readBridgeSize();
    }

    private static void printTitle() {
        outputView.printTitle();
    }
}
