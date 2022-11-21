package bridge.model.constant;

public enum Message {
    UP("U"),
    DOWN("D"),
    SUCCESS("O"),
    FAIL("X"),
    EMPTY(" ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
