package bridge.domain.vo;

import bridge.domain.constants.BridgeConstants;
import bridge.domain.constants.ErrorCode;

public class GameCommand {

    private final String input;

    public GameCommand(String input) {
        validateInput(input);
        this.input = input;
    }

    private void validateInput(String input) {
        if (!(input.equals(BridgeConstants.BRIDGE_GAME_COMMAND_R))
                ^ (input.equals(BridgeConstants.BRIDGE_GAME_COMMAND_Q))) {
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
