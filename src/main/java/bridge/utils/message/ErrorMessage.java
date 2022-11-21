package bridge.utils.message;

public enum ErrorMessage {
    EXIT("에러로 인해 게임을 종료합니다."),
    NON_NUMERIC_VALUE("숫자가 아닌 값을 입력하셨습니다."),
    BLANK_VALUE("빈 값을 입력하셨습니다."),
    INVALID_BRIDGE_SIZE("다리 길이는 %d부터 %d 사이의 숫자여야 합니다."),
    INVALID_VALUE("유효하지 않은 명령어 입니다."),
    LOWERCASE_VALUE("대문자로 입력해야 합니다.");

    private static final String ERROR_MESSAGE = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE + message;
    }
}
