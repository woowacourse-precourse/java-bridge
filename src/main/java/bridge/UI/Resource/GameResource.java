package bridge.UI.Resource;

public enum GameResource {
    ROW_OPEN("["),
    ROW_MID("|"),
    ROW_CLOSE("]\n"),
    GUESS_RIGHT(" O "),
    GUESS_WRONG(" X "),
    GUESS_NOTHING("   "),
    SUCCESS("성공"),
    FAILURE("실패");
    private String content;
    GameResource(String content) {
        this.content = content;
    }
    public String content() {
        return content;
    }
}
