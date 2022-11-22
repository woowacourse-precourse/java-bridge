package bridge.view;

public enum ErrorMessage {

    NOT_INTEGER_ERROR("[ERROR] 숫자만 입력해주세요."),
    BRIDGE_RANGE_ERROR("[ERROR] 다리 길이는 1 ~ 20로 입력해주세요."),
    DIRECTION_COMMEND_ERROR("[ERROR`] U,D 값 중 하나만 입력해주세요."),
    RETRY_COMMEND_ERROR("[ERROR] R,Q 값 중 하나만 입력해주세요.")
    ;

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
