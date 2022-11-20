package bridge.commom.constant;

public enum GameState {

    RUNNING("실행"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String message;

    GameState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
