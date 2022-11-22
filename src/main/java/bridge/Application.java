package bridge;

import bridge.view.OutputView;

public class Application {

    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        printTitle();
        askBridgeSize();
    }

    private static void askBridgeSize() {
        outputView.printBridgeSize();
    }

    private static void printTitle() {
        outputView.printTitle();
    }
}
