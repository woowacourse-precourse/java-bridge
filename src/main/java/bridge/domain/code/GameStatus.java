package bridge.domain.code;

import bridge.domain.bridge.Bridge;

public enum GameStatus {
    RUNNING("실행중"),
    CLEAR("성공"),
    FAIL("실패");

    private final String code;

    GameStatus(final String code) {
        this.code = code;
    }

    public static GameStatus generateGameStatus(SurviveStatus surviveStatus, Bridge bridge) {
        if (surviveStatus.isAlive() && bridge.canMove()) {
            return RUNNING;
        }
        if (surviveStatus.isAlive() && bridge.canNotMove()) {
            return CLEAR;
        }
        return FAIL;
    }

    public boolean isRunning() {
        return this.equals(RUNNING);
    }

    public String getCode() {
        return code;
    }

    public boolean isClear() {
        return this.equals(CLEAR);
    }
}
