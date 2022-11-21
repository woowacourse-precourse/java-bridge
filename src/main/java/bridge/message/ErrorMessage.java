package bridge.message;

public enum ErrorMessage {
    NOT_NUMBER_ERROR("[ERROR] 숫자를 입력해야 합니다."),
    NOT_MATCH_RANGE_ERROR("[ERROR] 숫자는 3~20 범위로 입력해야 합니다."),
    NOT_MATCH_MOVE_INPUT_ERROR("[ERROR] U 또는 D만 입력해야 합니다."),
    NOT_MATCH_RETRY_INPUT_ERROR("[ERROR] R 또는 Q만 입력해야 합니다.");


    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
