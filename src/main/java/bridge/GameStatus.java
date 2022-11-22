package bridge;

public enum GameStatus {
    SUCCESS("성공"),
    FAIL("실패"),
    PROCESSING("진행중");

    private String phrases;

    GameStatus (String phrases) {
        this.phrases = phrases;
    }

    @Override
    public String toString() {
        return phrases;
    }
}
