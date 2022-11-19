package bridge;

public enum ExceptionMessage {

    INVALID_NUMBER_RANGE_MESSAGE("[ERROR] 숫자의 범위는 3이상 20이하여야 합니다."),
    UNEXPECTED_INPUT_MESSAGE("[ERROR] 잘못된 입력입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
