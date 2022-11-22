package bridge.view;

public enum ErrorMessage {

    NOT_NUMERIC("숫자만 입력 가능합니다."),
    NOT_ALPHABETIC("알파벳만 입력 가능합니다."),

    INVALID_BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_DIRECTION("U 또는 D만 입력 가능합니다."),
    INVALID_GAME_COMMAND("Q 또는 R만 입력 가능합니다."),
    ;

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
