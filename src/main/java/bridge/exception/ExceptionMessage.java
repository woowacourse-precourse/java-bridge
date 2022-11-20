package bridge.exception;

public enum ExceptionMessage {
    NOT_NUMBER("[ERROR] 숫자가 아님"),
    NOT_RANGE("[ERROR] 숫자의 범위가 아님"),
    NOT_LENGTH("[ERROR] 입력 크기가 1또는 2가 아님"),
    NOT_MOVE_COMMEND("[ERROR] 입력한 명령어가 \"U\" 또는 \"D\" 가 아님"),
    NOT_GAME_COMMEND("[ERROR] 입력한 명령어가 \"R\" 또는 \"Q\" 가 아님");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
