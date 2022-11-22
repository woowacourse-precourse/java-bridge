package bridge.domain;

import java.util.Arrays;

public enum BridgeGameStatus {
    PLAY("R"),
    STOP("Q");

    private static final String INVALID_COMMAND_MESSAGE = "R과 Q 중 하나의 값을 입력해주세요.";

    private final String command;

    BridgeGameStatus(String command) {
        this.command = command;
    }

    public boolean isPlayable() {
        return this.equals(PLAY);
    }

    public boolean isNotPlayable() {
        return this.equals(STOP);
    }

    public static BridgeGameStatus gameStart() {
        return PLAY;
    }

    public static BridgeGameStatus getEnum(String command) {
        return Arrays.stream(values())
                .filter(status -> status.command.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_COMMAND_MESSAGE));
    }
}
