package bridge.input;

public enum Exception {

    LENGTH("1글자나 2글자여야 합니다."),
    FIRST_LETTER("첫글자는 0일 수 없습니다."),
    NUMBER("숫자가 아닌 값이 있습니다."),
    RANGE("범위를 벗어납니다."),
    MOVING("U나 D여야 합니다."),
    GAME_COMMAND("R이나 Q여야 합니다.");

    private final String message;

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
