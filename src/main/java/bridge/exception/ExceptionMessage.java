package bridge.exception;

import bridge.view.Message;

public enum ExceptionMessage implements Message {

    NULL("입력값이 null입니다."),
    EMPTY_STRING("입력값이 빈 문자열입니다"),
    INTEGER_TYPE_MISMATCH("정수형 입력이 아닙니다."),
    LOWER_BRIDGE_SIZE("다리의 길이 입력값이 3미만입니다."),
    UPPER_BRIDGE_SIZE("다리의 길이 입력값이 20초과입니다."),
    MOVING_DIRECTION("이동할 칸의 입력값이 'U'또는 'D'가 아닙니다."),
    GAME_COMMAND("재시도 또는 종료 입력값이 'R'또는 'Q'가 아닙니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String text() {
        return String.format("[ERROR] %s", message);
    }
}
