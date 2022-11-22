package bridge.command;

import bridge.exception.BridgeGameError;

public enum GameCommand {
    REPLAY,
    QUIT;

    GameCommand() {
    }

    public static GameCommand setGameCommand(String input) {
        if (input.equals("R")) {
            return GameCommand.REPLAY;
        }
        if (input.equals("Q")) {
            return GameCommand.QUIT;
        }
        throw new IllegalArgumentException(BridgeGameError.INVALID_TYPE_GAME_COMMAND.getErrorMessage());
    }
}
