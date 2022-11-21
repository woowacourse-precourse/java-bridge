package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();

            outputView.printStartMessage();
            outputView.printMessageForBridgeSize();
            inputView.readBridgeSize();
            outputView.printMessageForMoving();
            inputView.readMoving();
            outputView.printMessageForGameCommand();
            inputView.readGameCommand();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}
