package bridge.messages;

public enum ExceptionMessage {
    ERROR_INPUT_LENGTH_ZERO("[ERROR] 아무것도 입력하지 않았습니다."),
    ERROR_NOT_INTEGER("[ERROR] 숫자를 입력해야 합니다."),
    ERROR_INVALID_MOVE_COMMAND("[ERROR] 위: U, 아래: D 로 입력해 주세요."),
    ERROR_INVALID_GAME_COMMAND("[ERROR] 재시작: R, 종료: Q 로 입력해 주세요.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
