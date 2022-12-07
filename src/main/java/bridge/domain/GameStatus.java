package bridge.domain;

public enum GameStatus {
    FAIL("실패"),
    SUCCESS("성공"),
    RUNNING("실행 중");

    private final String status;

    GameStatus(String status) {
        this.status = status;
    }

    public static GameStatus of(BridgeMoving bridgeMoving, MovingResult movingResult) {
        if (movingResult.isFail()) {
            return FAIL;
        }
        if (bridgeMoving.isComplete()) {
            return SUCCESS;
        }
        return RUNNING;
    }

    public boolean isRunning() {
        return this == RUNNING;
    }

    public boolean isFail() {
        return this == FAIL;
    }

    public String getStatus() {
        return this.status;
    }
}
