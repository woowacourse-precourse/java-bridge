package bridge;

public enum GameStatus {
    PLAYING("진행"),
    WIN("성공"),
    FAIL("실패")
    ;

    private final String status;

    GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
