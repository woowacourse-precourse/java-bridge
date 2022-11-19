package bridge.domain;

public enum GameFlag {
    PLAYING("게임 진행중"),
    CLEAR("성공"),
    FAIL("실패");

    private final String message;

    GameFlag(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
