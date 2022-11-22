package bridge.domain.vo;

import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MOVING_DOWN;
import static bridge.domain.constants.BridgeConstants.BRIDGE_GAME_MOVING_UP;

import bridge.domain.constants.ErrorCode;

public class Moving {

    private final String input;

    private Moving(String input) {
        validateInput(input);
        this.input = input;
    }

    public static Moving from(String input) {
        return new Moving(input);
    }

    private void validateInput(String input) {
        if (!(input.equals(BRIDGE_GAME_MOVING_UP))
                ^ (input.equals(BRIDGE_GAME_MOVING_DOWN))) {
            throw ErrorCode.MOVING_NOT_U_D.getException();
        }
    }

    public boolean equals(String input) {
        return this.input.equals(input);
    }
}
