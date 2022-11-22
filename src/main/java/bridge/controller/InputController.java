package bridge.controller;

import bridge.utils.ErrorMessage;
import bridge.view.InputView;

public class InputController {
    public static int requestBridgeSize() {
        try {
            return InputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            ErrorMessage.print(e.getMessage());
            return requestBridgeSize();
        }
    }

    public static String requestMovingDirection() {
        try {
            return InputView.readMoving();
        } catch (IllegalArgumentException e) {
            ErrorMessage.print(e.getMessage());
            return requestMovingDirection();
        }
    }

    public static String requestGameCommand() {
        try {
            return InputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            ErrorMessage.print(e.getMessage());
            return requestGameCommand();
        }
    }
}