package bridge.exception;

public enum ExceptionMessage {
    INPUT_SHOULD_BE_U_OR_D("U 또는 D를 입력해야합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
