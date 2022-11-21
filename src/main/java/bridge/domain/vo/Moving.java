package bridge.domain.vo;

import bridge.domain.constants.BridgeConstants;
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
        if (!(input.equals(BridgeConstants.BRIDGE_GAME_MOVING_UP))
                ^ (input.equals(BridgeConstants.BRIDGE_GAME_MOVING_DOWN))) {
            throw ErrorCode.MOVING_NOT_U_D.getException();
        }
    }

    public boolean equals(String input) {
        return this.input.equals(input);
    }
}
