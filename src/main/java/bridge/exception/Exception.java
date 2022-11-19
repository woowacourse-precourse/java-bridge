package bridge.exception;

public enum Exception {
    SIZE_RANGE_EXCEPTION(new IllegalArgumentException("[ERROR] " + "3 ~ 20 사이의 수를 입력해주세요")),
    BRIDGE_NUMBER_RANGE_EXCEPTION(new IllegalArgumentException("[ERROR] " + "0 또는 1이 아닙니다.")),
    IS_NOT_NUMBER_EXCEPTION(new IllegalArgumentException("[ERROR] " + "입력이 숫자가 아닙니다.")),
    WRONG_LENGTH_EXCEPTION(new IllegalArgumentException("[ERROR] " + "입력의 길이가 다릅니다.")),
    IS_NOT_LETTER_EXCEPTION(new IllegalArgumentException("[ERROR] " + "입력이 문자가 아닙니다.")),
    IS_NOT_COURSE_EXCEPTION(new IllegalArgumentException("[ERROR] " + "U 또는 D를 입력해주세요."));
    private IllegalArgumentException exception;

    Exception(IllegalArgumentException exception) {
        this.exception = exception;
    }

    public IllegalArgumentException getException() {
        return exception;
    }
}
