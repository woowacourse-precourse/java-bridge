package bridge;

public enum ErrorMessage {
    INVALID_BRIDGE_SIZE("숫자를 입력해 주세요."),
    INVALID_MOVING_VALUE("'U'(위) 또는 'D'(아래)를 입력해 주세요."),
    INVALID_GAME_COMMAND_VALUE("'R'(재시작) 또는 'Q'(종료)를 입력해 주세요.");

    String message;

    ErrorMessage(String message) {
        this.message =  "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
