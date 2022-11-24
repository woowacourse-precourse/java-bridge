package bridge.domain;

import bridge.messages.ErrorMessage;
import bridge.messages.Message;

import java.util.List;

public class UpDownBridgeValidator {

    public static void validateUpBridge(List<String> upBridge) {
        validateUpBridgeNull(upBridge);
        validateUpBridgeData(upBridge);
    }

    public static void validateDownBridge(List<String> downBridge) {
        validateDownBridgeNull(downBridge);
        validateDownBridgeData(downBridge);
    }

    private static void validateUpBridgeNull(List<String> upBridge) {
        if (upBridge.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.BRIDGE_IS_EMPTY.getErrorMessage());
        }
    }

    private static void validateUpBridgeData(List<String> upBridge) {
        if (!upBridge.contains(Message.MOVE_SUCCESS.getMessage()) && !upBridge.contains(
                Message.MOVE_FAIL.getMessage()) && !upBridge.contains(Message.BLANK.getMessage())) {
            throw new IllegalStateException(ErrorMessage.BRIDGE_HAS_WRONG_DATA.getErrorMessage());
        }
    }


    private static void validateDownBridgeNull(List<String> downBridge) {
        if (downBridge.isEmpty()) {
            throw new IllegalStateException(ErrorMessage.BRIDGE_IS_EMPTY.getErrorMessage());
        }
    }

    private static void validateDownBridgeData(List<String> downBridge) {
        if (!downBridge.contains(Message.MOVE_SUCCESS.getMessage()) && !downBridge.contains(
                Message.MOVE_FAIL.getMessage()) && !downBridge.contains(Message.BLANK.getMessage())) {
            throw new IllegalStateException(ErrorMessage.BRIDGE_HAS_WRONG_DATA.getErrorMessage());
        }
    }
}
