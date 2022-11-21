package bridge;

public enum GameStatus {
    STATUS_PLAY(0, ""),
    STATUS_FAIL(1, ""),
    STATUS_SUCCESS(2, "성공"),
    STATUS_QUIT(3, "실패");

    private final int code;
    private final String text;

    private GameStatus(int code, String text) {
        this.code = code;
        this.text = text;
    }

    public int getCode() {
        return this.code;
    }

    public String getText() {
        return this.text;
    }

}
