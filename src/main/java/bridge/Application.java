package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printStartMessage();
        outputView.printMessageForBridgeSize();
        inputView.readBridgeSize();
        outputView.printMessageForMoving();
        inputView.readMoving();
    }
}
