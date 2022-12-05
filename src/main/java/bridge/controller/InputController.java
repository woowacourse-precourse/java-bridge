package bridge.controller;

import bridge.view.InputView;

public class InputController {
    private final InputView inputView = new InputView();

    public int readBridgeSizeUntilSucceed() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readMovingUntilSucceed() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readGameCommandUntilSucceed() {
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
