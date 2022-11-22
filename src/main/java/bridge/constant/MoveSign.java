package bridge.constant;

public enum MoveSign {
    MOVE_SUCCESS("O"),
    MOVE_FAIL("X");

    private String message;

    MoveSign(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
