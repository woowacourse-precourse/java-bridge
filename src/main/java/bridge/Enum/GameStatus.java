package bridge.Enum;

public enum GameStatus {
    RUNNING("게임 진행중"),
    FAIL("실패"),
    SUCCESS("성공");

    private String status;

    private GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
