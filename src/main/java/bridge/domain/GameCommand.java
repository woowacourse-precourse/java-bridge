package bridge.domain;

import bridge.exception.BridgeGameError;
import bridge.exception.CommandException;

public enum GameCommand {
    REPLAY,
    QUIT;

    GameCommand() {
    }

    public static GameCommand setCommand(String input) {
        if (input.equals("R")) {
            return GameCommand.REPLAY;
        }
        if (input.equals("Q")) {
            return GameCommand.QUIT;
        }
        throw new CommandException(BridgeGameError.INVALID_GAME_COMMAND_INPUT);
    }
}
