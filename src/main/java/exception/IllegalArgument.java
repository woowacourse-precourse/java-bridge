package exception;

import constants.BridgeConstant;
import constants.CommandTable;
import constants.DirectionTable;

public enum IllegalArgument {
    NOT_BRIDGE_INPUT(String.format("다리의 길이는 %d ~ %d 사이의 숫자 중 하나를 입력해야 합니다."
            , BridgeConstant.MIN_BRIDGE_SIZE, BridgeConstant.MAX_BRIDGE_SIZE)),
    NOT_MOVING_INPUT(String.format("이동할 방향은 %s, %s 중에서 하나를 입력해야 합니다."
            , DirectionTable.UP.getInitial(), DirectionTable.DOWN.getInitial())),
    NOT_COMMAND_INPUT(String.format("진행 여부를 결정하려면 %s, %s 중에서 하나를 입력해야 합니다."
            , CommandTable.RETRY.getInitial(), CommandTable.QUIT.getInitial()));

    private final String message;

    IllegalArgument(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }

    public static void handleException(String message) throws IllegalArgumentException {
        throw new IllegalArgumentException(message);
    }
}
