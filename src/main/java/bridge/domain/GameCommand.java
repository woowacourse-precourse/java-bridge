package bridge.domain;

import java.util.Arrays;

public enum GameCommand {
    RETRY(true, "R"),
    QUIT(false, "Q");

    private final boolean isRetry;
    private final String command;

    GameCommand(boolean isRetry, String command) {
        this.isRetry = isRetry;
        this.command = command;
    }

    public boolean isRetry() {
        return isRetry;
    }

    public static GameCommand of(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Q 또는 R을 입력해주세요"));
    }
}