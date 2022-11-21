package bridge;

import java.util.Arrays;

public enum BridgeGameCommandType {
    RESTART(true, "R"),
    QUIT(false, "Q");

    private final boolean isRestart;
    private final String gameCommand;

    BridgeGameCommandType(final boolean isRestart, final String gameCommand) {
        this.isRestart = isRestart;
        this.gameCommand = gameCommand;
    }

    public boolean getIsRestart() {
        return this.isRestart;
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
