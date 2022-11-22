package bridge.Exception;

public enum ErrorMessage {
    NOT_NUMERIC_VALUE("[ERROR] 숫자만 입력해야 합니다."),
    NOT_VALID_INTERVAL_VALUE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_VALID_MOVING("[ERROR] 이동은 U(UP) 또는 D(DOWN) 중 하나만 선택하여 입력해야 합니다."),
    NOT_VALID_COMMAND("[ERROR] 커맨드는 R(RETRY) 또는 Q(QUIT) 중 하나만 선택하여 입력해야 합니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
