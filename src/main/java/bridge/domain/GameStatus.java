package bridge.domain;

public enum GameStatus {
    RESULT_PREFIX("게임 성공 여부: "),
    SUCCESS("성공"),
    FAIL("실패"),
    RUNNING("진행 중");

    private final String status;

    GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getResult() {
        return RESULT_PREFIX.getStatus() + status;
    }
}
