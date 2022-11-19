package bridge.constant;

public enum GameStatus {

    SUCCESS("성공"),
    FAIL("실패"),
    ;

    private final String message;

    GameStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
