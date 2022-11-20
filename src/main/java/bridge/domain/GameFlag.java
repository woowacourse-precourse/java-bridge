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

    public boolean isClear() {
        return this.equals(CLEAR);
    }

    public boolean isFail() {
        return this.equals(FAIL);
    }

    public boolean isPlaying() {
        return this.equals(PLAYING);
    }
}
