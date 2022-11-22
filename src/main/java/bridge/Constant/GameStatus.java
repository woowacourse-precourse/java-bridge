package bridge.Constant;

public enum GameStatus {
    STATUS_PLAY("진행중"),
    STATUS_FAIL("실패"),
    STATUS_SUCCESS("성공");

    private final String text;

    private GameStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

}
