package bridge.exception;

public enum ErrorCode {

    INVALID_SIZE("적절하지 않은 크기입니다."),
    INVALID_SIGNATURE_NUMBER("적절하지 않은 숫자 입니다."),
    INVALID_SIGNATURE_LETTER("적절하지 않은 문자 입니다."),
    INDEX_OUT_OF_BOUND("해당 인덱스는 범위 밖 값입니다."),
    NOT_NUMERIC_VALUE("숫자만 입력할 수 있습니다."),
    OUT_OF_RANGE("%d와 %d 사이의 값만 입력할 수 있습니다."),
    INVALID_INPUT("해당 문자는 입력할 수 없습니다.");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
