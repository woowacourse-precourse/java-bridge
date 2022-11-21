package bridge;

import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
        String bridgeCommand = inputView.readMoving();
    }
}
