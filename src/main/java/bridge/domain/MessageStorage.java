package bridge.domain;

public enum MessageStorage {
    UP("U"),
    DOWN("D"),
    CORRECT("O"),
    INCORRECT("X"),
    RESTART("R"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String message;

    MessageStorage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
