package exception;

public enum ExceptionMessage {
    INVALID_BRIDGE_SIZE("잘못된 입력 입니다. 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVE("잘못된 입력 입니다. U(위), D(아래)를 입력해 주세요."),
    INVALID_INPUT("잘못된 입력 입니다. 알맞게 입력해 주세요.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
