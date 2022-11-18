package bridge.utils.message;

public enum ErrorMessage {
    EXIT("에러로 인해 게임을 종료합니다."),
    NON_NUMERIC_VALUE("숫자가 아닌 값을 입력하셨습니다."),
    BLANK_VALUE("빈 값을 입력하셨습니다.");

    private static final String ERROR_MESSAGE = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE + message;
    }
}
