package bridge.controller;

import bridge.util.ExceptionMessage;
import bridge.view.InputView;

public class InputController {
    private final InputView inputView;

    public InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public int getBridgeSize() throws IllegalArgumentException {
        int result;
        try {
            result = Integer.parseInt(inputView.readBridgeSize());
            isValidBridgeSize(result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE
                    + ExceptionMessage.CANNOT_CONVERT_TO_NUMBER);
        }
        return result;
    }

    private void isValidBridgeSize(int size) throws IllegalArgumentException {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MESSAGE
                    + ExceptionMessage.BRIDGE_SIZE_OUT_OF_RANGE);
        }
    }

    public String getMovingDirection() {
        return inputView.readMoving();
    }

    public String getGameCommand() {
        return inputView.readGameCommand();
    }
}
