package bridge.controller;

import bridge.view.InputView;

public class InputController {
    private static final InputView inputView = new InputView();

    public static int readBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
