package bridge.utils.enums;

public enum Errors {
    RANGE("%d 이상 %d 이하의 숫자만 입력가능합니다."),
    UNREQUIRED("보기에 있는 값만 입력 가능합니다."),
    NOT_NUMBER("숫자만 입력 가능합니다.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
