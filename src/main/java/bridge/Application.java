package bridge;

import bridge.UI.Input.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.readBridgeSize();
        inputView.readMoving();
        inputView.readGameCommand();
    }
}
