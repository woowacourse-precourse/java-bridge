package bridge.domain;

import static bridge.domain.UpDownBridge.getDownBridge;
import static bridge.domain.UpDownBridge.getUpBridge;

import bridge.messages.ErrorMessage;
import bridge.messages.Message;

public class UpDownBridgeValidator {

    public static void validateUpDownBridge() {
        validateUpBridgeNull();
        validateUpBridgeData();
        validateDownBridgeNull();
        validateDownBridgeData();
    }

    private static void validateUpBridgeNull() {
        if (getUpBridge().isEmpty()) {
            throw new IllegalStateException(ErrorMessage.BRIDGE_IS_EMPTY.getErrorMessage());
        }
    }

    private static void validateDownBridgeNull() {
        if (getDownBridge().isEmpty()) {
            throw new IllegalStateException(ErrorMessage.BRIDGE_IS_EMPTY.getErrorMessage());
        }
    }

    private static void validateUpBridgeData() {
        if (!getUpBridge().contains(Message.MOVE_SUCCESS.getMessage()) && !getUpBridge().contains(
                Message.MOVE_FAIL.getMessage()) && !getUpBridge().contains(Message.BLANK.getMessage())) {
            throw new IllegalStateException(ErrorMessage.BRIDGE_HAS_WRONG_DATA.getErrorMessage());
        }
    }

    private static void validateDownBridgeData() {
        if (!getDownBridge().contains(Message.MOVE_SUCCESS.getMessage()) && !getDownBridge().contains(
                Message.MOVE_FAIL.getMessage()) && !getDownBridge().contains(Message.BLANK.getMessage())) {
            throw new IllegalStateException(ErrorMessage.BRIDGE_HAS_WRONG_DATA.getErrorMessage());
        }
    }
}
