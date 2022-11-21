package bridge.game.bridgeGame;

public enum BridgeGameStatus {
    BEFORE_START,
    CORRECT,
    FALL,
    ;

    public boolean isContinue() {
        return this.equals(BridgeGameStatus.FALL) || this.equals(BridgeGameStatus.CORRECT);
    }
}


