package bridge.domain.code;

import bridge.domain.bridge.Bridge;

public enum GameStatus {
    RUNNING("실행중"),
    CLEAR("성공"),
    FAIL("실패");

    private static final String RESULT_MESSAGE = "게임 성공 여부: %s";
    private final String code;

    GameStatus(final String code) {
        this.code = code;
    }

    public static GameStatus generateGameStatus(SurviveStatus surviveStatus, Bridge bridge) {
        if (surviveStatus.isDie()) {
            return FAIL;
        }
        if (bridge.canMove()) {
            return RUNNING;
        }
        return CLEAR;
    }

    public boolean isRunning() {
        return this.equals(RUNNING);
    }

    public String resultMessage() {
        return String.format(RESULT_MESSAGE, code);
    }

    public boolean isClear() {
        return this.equals(CLEAR);
    }
}
