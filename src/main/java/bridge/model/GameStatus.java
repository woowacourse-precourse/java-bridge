package bridge.model;

public enum GameStatus {
    SUCCESS("성공", true),
    FAIL("실패", false);

    private final String detail;
    private final boolean life;

    GameStatus(String key, boolean value) {
        this.detail = key;
        this.life = value;
    }

    public static GameStatus resultPlaying(boolean life) {
        if (life) {
            return SUCCESS;
        }
        return FAIL;
    }

    public String getDetail() {
        return this.detail;
    }

    public boolean isLife() {
        return this.life;
    }
}
