package bridge.model;

import bridge.util.BridgeGameExceptionMessage;

public enum GameCommand {
    R, Q;

    public static GameCommand fromInput(String gameCommand) {
        try {
            return valueOf(gameCommand);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(BridgeGameExceptionMessage.COMMAND_NOT_MATCH.getMessage());
        }
    }
}
