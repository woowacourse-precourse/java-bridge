package bridge.domain;

public enum BridgeGameState {
    START,
    CONTINUE,
    WIN,
    LOSE;

    public boolean isContinue() {
        return this == CONTINUE;
    }

    public boolean isWin() {
        return this == WIN;
    }

    public boolean isLose() {
        return this == LOSE;
    }

    public boolean isBridgeGameContinue() {
        return this == START || this == CONTINUE;
    }

    public boolean isBridgeGameEnd() {
        return this == WIN || this == LOSE;
    }
}
