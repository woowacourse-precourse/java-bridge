package bridge.validator;

import bridge.exception.ExceptionMessage;

public class InputValidator {
    public void validateBridgeSize(int size) {
        if(size < 3 || size > 20) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE.getMessage());
        }
    }

    public  void validateMove(String move) {
        if(!(move.equals("U") || move.equals("D"))) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_BE_U_OR_D.getMessage());
        }
    }

    public void validateRetry(String retryQuit) {
        if(!(retryQuit.equals("R") || retryQuit.equals("Q"))) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_SHOULD_BE_U_OR_D.getMessage());
        }
    }
}
