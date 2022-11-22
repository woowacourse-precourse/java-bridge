package bridge.domain.vo;

import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_COMMAND_QUIT;
import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_COMMAND_RETRY;

import bridge.domain.constants.ErrorCode;

public class GameCommand {

    private final String input;

    private GameCommand(String input) {
        validateInput(input);
        this.input = input;
    }

    public static GameCommand from(String input) {
        return new GameCommand(input);
    }

    private void validateInput(String input) {
        if (!(input.equals(BRIDGE_GAME_COMMAND_RETRY))
                ^ (input.equals(BRIDGE_GAME_COMMAND_QUIT))) {
            throw ErrorCode.GAME_COMMAND_NOT_R_Q.getException();
        }
    }

    @Override
    public String toString() {
        return input;
    }

    public boolean equals(String input) {
        return this.input.equals(input);
    }
}
