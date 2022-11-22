package bridge;

import java.util.Arrays;

public enum BridgeGameCommandType {

    RESTART(true, "R"),
    QUIT(false, "Q");

    private final boolean isRetry;
    private final String gameCommand;

    BridgeGameCommandType(final boolean isRestart, final String gameCommand) {
        this.isRetry = isRestart;
        this.gameCommand = gameCommand;
    }

    public boolean getIsRetry() {
        return this.isRetry;
    }

    public String getGameCommand() {
        return this.gameCommand;
    }

    public static BridgeGameCommandType getFindByGameCommand(String command) {
        return Arrays.stream(values())
                .filter(gameCommandType -> gameCommandType.gameCommand.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMesssage.BRIDGE_STAIRS_TYPE_ERROR.getMessage()));
    }
}
