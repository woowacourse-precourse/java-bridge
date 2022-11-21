package bridge.model;

public enum GameCommand {
    RETRY("R"), QUIT("Q");

    private final String sign;

    GameCommand(final String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
