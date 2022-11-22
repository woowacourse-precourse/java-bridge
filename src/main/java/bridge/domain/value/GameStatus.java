package bridge.domain.value;

import bridge.domain.BridgeMoving;

import java.util.List;

public enum GameStatus {
    FAIL("실패"),
    SUCCESS("성공"),
    RUNNING("실행 중");

    private final String status;

    GameStatus(String status) {
        this.status = status;
    }

    public static GameStatus of(BridgeMoving bridgeMoving, String movingResult) {
        if (bridgeMoving.isFail(movingResult)) {
            return FAIL;
        }
        if (bridgeMoving.isComplete()) {
            return SUCCESS;
        }
        return RUNNING;
    }

    public boolean isRunning() {
        return this.equals(RUNNING);
    }

    public boolean isFail() {
        return this.equals(FAIL);
    }

    public String getStatus() {
        return this.status;
    }
}
