package bridge.domain;

public enum GameStatus {
    WIN("성공"),
    LOSE("실패"),
    KEEP_GOING("성공");

    private final String status;

    private GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
