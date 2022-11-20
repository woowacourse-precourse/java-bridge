package bridge.type;

public enum GameStatusType {
    PLAYING("진행", true),
    END("성공", false),
    FAIL("실패", false);

    private final String gameStatus;
    private final boolean playing;

    GameStatusType(String gameStatus, boolean isPlaying) {
        this.gameStatus = gameStatus;
        this.playing = isPlaying;
    }

    public String toString() {
        return gameStatus;
    }

    public boolean isPlaying() {
        return playing;
    }
}
