package bridge.domain;

public enum BridgeGameStatus {
    PLAY("R"),
    QUIT("Q");

    private final String command;

    BridgeGameStatus(String command) {
        this.command = command;
    }

    public static BridgeGameStatus gameStart() {
        return PLAY;
    }

    public static BridgeGameStatus gameRestart() {
        return PLAY;
    }

    public boolean isRunning() {
        return this.equals(PLAY);
    }

    public boolean isNotRunning() {
        return this.equals(QUIT);
    }
}
