package bridge.exception;

import static bridge.utils.constant.OutputMessage.ERROR;

public enum Exception {
    NOT_NUMBER(ERROR + "잘못된 입력값입니다. 숫자(정수)를 입력해주세요."),
    OUT_OF_RANGE(ERROR + "다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_DIRECTION(ERROR + "U(위 칸) 혹은 D(아래 칸)만 입력 가능합니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public void throwException() {
        throw new IllegalArgumentException(message);
    }
}