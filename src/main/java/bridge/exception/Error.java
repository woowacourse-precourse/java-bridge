package bridge.exception;

import bridge.domain.BridgeLength;
import bridge.domain.GameCommand;
import bridge.domain.Moving;

public enum Error {
    NOT_INT("숫자를 입력하세요."),
    WRONG_BRIDGE_LENGTH("다리 길이는 " + BridgeLength.MIN + "부터 " + BridgeLength.MAX + " 사이의 숫자여야 합니다."),
    WRONG_MOVING("이동할 수 있는 칸은 " + Moving.UP.getExpression() + "(" + Moving.UP.getDescription() + ")"
                         + "와 " + Moving.DOWN.getExpression() + "(" + Moving.DOWN.getDescription()
                         + ")" + "여야 합니다."),
    WRONG_GAME_COMMAND("게임 재시작/종료 여부는 " + GameCommand.RETRY.getExpression() + "("
                               + GameCommand.RETRY.getDescription() + ")" + "와 "
                               + GameCommand.QUIT.getExpression() + "("
                               + GameCommand.QUIT.getDescription() + ")" + "여야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }

}
