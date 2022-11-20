package bridge.domain.vo;

import bridge.domain.constants.BridgeConstants;
import bridge.domain.constants.ErrorCode;

public class Moving {

    private final String input;

    public Moving(String input) {
        validateInput(input);
        this.input = input;
    }

    private void validateInput(String input) {
        if (!(input.equals(BridgeConstants.BRIDGE_GAME_MOVING_U))
                ^ (input.equals(BridgeConstants.BRIDGE_GAME_MOVING_D))) {
            throw ErrorCode.MOVING_NOT_U_D.getException();
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
