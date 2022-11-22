package bridge.exception;

import bridge.model.bridge.BridgeInfo;
import bridge.model.game.Command;
import bridge.model.game.Direction;

public enum ErrorMsg {

    WRONG_BRIDGE_SIZE("[ERROR] 다리의 길이는 " + BridgeInfo.MIN.getValue() + "부터 " + BridgeInfo.MAX.getValue() + " 사이의 숫자여야 합니다.\n"),
    NOT_ALLOWED_MOVEMENT("[ERROR] 이동은 " + String.join(", ", Direction.names()) + "만 입력 가능합니다."),
    NOT_ALLOWED_COMMAND("[ERROR] " + String.join(", ", Command.names()) + "만 입력 가능합니다.");

    private final String msg;

    ErrorMsg(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return this.msg;
    }
}
