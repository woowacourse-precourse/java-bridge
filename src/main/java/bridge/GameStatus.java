package bridge;

public enum GameStatus {
    STATUS_PLAY(0, "진행중"),
    STATUS_FAIL(1, "실패"),
    STATUS_SUCCESS(2, "성공");

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
