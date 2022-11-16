package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        try {
            int size = inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {

        }
    }
}
