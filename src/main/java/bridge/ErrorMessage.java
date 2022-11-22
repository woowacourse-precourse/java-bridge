package bridge;

public enum ErrorMessage {
    NOT_NUMERIC_VALUE("[Error] 숫자만 입력해야 합니다."),
    NOT_VALID_INTERVAL_VALUE("[Error] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_VALID_MOVING("[Error] 이동은 U(UP) 또는 D(DOWN) 중 하나만 선택하여 입력해야 합니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
