package bridge.utils;

import bridge.constant.ExceptionMessage;
import bridge.view.InputView;
import bridge.view.OutputView;

public class InputService {
    private static InputService inputService = new InputService();

    private InputService() {
    }

    public static InputService getInputService() {
        if (inputService == null) {
            inputService = new InputService();
        }
        return inputService;
    }

    public int inputBridgeSize() {
        while (true) {
            try {
                return InputView.getInputView().readBridgeSize();
            } catch (IllegalArgumentException exception) {
                OutputView.getOutputView().printErrorMessage(ExceptionMessage.BRIDGE_RANGE.getMessage());
            }
        }
    }

    public String inputPlayerMoving() {
        while (true) {
            try {
                return InputView.getInputView().readMoving();
            } catch (IllegalArgumentException exception) {
                OutputView.getOutputView().printErrorMessage(ExceptionMessage.MOVE.getMessage());
            }
        }
    }

    public String inputRetryCommand() {
        while (true) {
            try {
                return InputView.getInputView().readGameCommand();
            } catch (IllegalArgumentException exception) {
                OutputView.getOutputView().printErrorMessage(ExceptionMessage.RETRY_INPUT.getMessage());
            }
        }
    }
}
