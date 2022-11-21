package bridge.exception;

import bridge.domain.BrideLength;
import bridge.domain.Moving;

public enum Error {
    NOT_INT("숫자를 입력하세요."),
    WRONG_BRIDGE_LENGTH("다리 길이는 " + BrideLength.MIN + "부터 " + BrideLength.MAX + " 사이의 숫자여야 합니다."),
    WRONG_MOVING("이동할 수 있는 칸은 " + Moving.UP.getExpression() + "(" + Moving.UP.getDescription() +")" + "와 " + Moving.DOWN.getExpression() + "(" + Moving.DOWN.getDescription() +")" +"여야 합니다.");

    private final String ERROR = "[ERROR] ";
    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }

}
