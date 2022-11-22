package bridge.enums;

public enum GameResult {
    SUCCESS("성공"),
    FAILED("실패");

    private final String comment;

    private GameResult(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
