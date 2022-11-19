package bridge.validator;

public enum ErrorType {
    INVALID_FORMAT ("[ERROR] 입력이 숫자가 아닙니다."),
    INVALID_RANGE ("[ERROR] 다리 길이 입력의 범위는 3 ~ 20이어야 합니다."),
    INVALID_MOVE_INPUT ("[ERROR] 이동 입력은 'U'나 'D'가 들어와야 합니다."),
    INVALID_RETRY_INPUT ("[ERROR] 재시작 입력은 'R'이나 'Q'가 들어와야 합니다."),
    EMPTY_INPUT("[ERROR] 입력이 공백이면 안됩니다.");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
