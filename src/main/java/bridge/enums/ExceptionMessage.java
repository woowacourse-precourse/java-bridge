package bridge.enums;

public enum ExceptionMessage {
    IS_NOT_RANGED_NUMBER("[ERROR] 입력 범위에 맞지 않는 숫자입니다. 3 ~ 20 사이의 자연수를 입력하세요."),
    IS_NOT_NUMBER("[ERROR] 자연수만 입력할 수 있습니다."),
    IS_NOT_VALID_GAME_COMMAND("[ERROR] U 혹은 D만 입력할 수 있습니다."),
    IS_NOT_VALID_RETRY_MESSAGE("[ERROR] Q 혹은 R만 입력할 수 있습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
