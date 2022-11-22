package bridge.domain;

import bridge.common.ErrorMessage;
import java.util.Arrays;

public enum BridgeGameStatus {
    PLAY("R"),
    QUIT("Q");

    private final String command;

    BridgeGameStatus(String command) {
        this.command = command;
    }

    public static BridgeGameStatus of(String command) {
        return Arrays.stream(values())
                .filter(gameStatus -> gameStatus.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.isInvalidGameCommand()));
    }

    public static BridgeGameStatus gameStart() {
        return PLAY;
    }

    public static BridgeGameStatus gameRestart() {
        return PLAY;
    }

    public boolean isPlayStatus() {
        return this.equals(PLAY);
    }

    public boolean isQuitStatus() {
        return this.equals(QUIT);
    }
}
