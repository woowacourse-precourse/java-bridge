package bridge.gameComponent;

import bridge.exception.ExceptionMessage;
import bridge.util.BridgeSizeRule;
import bridge.util.UserInput;

public class InputValidator {
    public void validateBridgeSize(int size) {
        if(size < BridgeSizeRule.BRIDGE_MIN_SIZE.getSize() || size > BridgeSizeRule.BRIDGE_MAX_SIZE.getSize()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    public  void validateMove(String move) {
        if(!(move.equals(UserInput.UP.getInputValue()) || move.equals(UserInput.DOWN.getInputValue()))) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_BE_U_OR_D.getMessage());
        }
    }

    public void validateRetry(String retryQuit) {
        if(!(retryQuit.equals(UserInput.RETRY.getInputValue()) || retryQuit.equals(UserInput.QUIT.getInputValue()))) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_BE_U_OR_D.getMessage());
        }
    }
}
