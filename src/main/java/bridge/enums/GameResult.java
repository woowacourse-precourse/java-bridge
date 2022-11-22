package bridge.enums;

public enum GameResult {
    SUCCESS("성공"),
    FAILED("실패"),
    UNDETERMINED("아직 결정되지 않음");

    private final String comment;

    GameResult(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
