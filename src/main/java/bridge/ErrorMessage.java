package bridge;

public enum ErrorMessage {
    NotNumberFormat("숫자를 입력해주세요."),
    NotValidBridgeSize("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NotValidBridgeElement("올바르지 않은 값이 다리에 있습니다."),
    NotValidUserMovement("잘못된 유저 이동입니다."),
    NotValidUserCommand("잘못된 명령어 입력입니다.");

    private final String format = "[ERROR] ";
    private String message;

    ErrorMessage(String message) {
        this.message = format + message;
    }

    public String getMessage() {
        return message;
    }
}
