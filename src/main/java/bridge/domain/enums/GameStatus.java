package bridge.domain.enums;

public enum GameStatus {
    WIN("성공"),
    LOSE("실패"),
    KEEP_GOING("계속 진행");

    private final String status;

    private GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
