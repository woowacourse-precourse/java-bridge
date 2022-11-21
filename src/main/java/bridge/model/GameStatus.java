package bridge.model;

public enum GameStatus {
    PLAYING("진행", true),
    SUCCESS("성공", false),
    FAIL("실패", false);

    private final String detail;
    private final boolean playing;

    GameStatus(String key, boolean value) {
        this.detail = key;
        this.playing = value;
    }

    public String getDetail() {
        return detail;
    }

    public boolean isPlaying() {
        return playing;
    }
}
