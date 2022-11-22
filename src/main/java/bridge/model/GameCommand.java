package bridge.model;

import java.util.Objects;

public enum GameCommand {

    RETRY("R"), QUIT("Q");

    private final String sign;

    GameCommand(final String sign) {
        this.sign = sign;
    }

    public static boolean isRetryCommand(final String gameCommand) {
        return Objects.equals(gameCommand, RETRY.getSign());
    }

    public String getSign() {
        return sign;
    }
}
