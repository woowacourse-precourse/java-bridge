package bridge;

public enum ExceptionMessage {
    NOT_NUMBER("[ERROR] 숫자만 입력해주세요."),
    NOT_SIZE_RANGE("[ERROR] 3 이상 20 이하의 숫자만 입력해주세요."),
    NOT_MOVE_INVALID("[ERROR] 'U' 또는 'D'만 입력해주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getExceptionMessage() {
        return message;
    }


}
