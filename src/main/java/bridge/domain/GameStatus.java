package bridge.domain;

public enum GameStatus {
    CONTINUE("진행중"), FAIL("실패"), CORRECT("성공");

    private final String message;

    GameStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
