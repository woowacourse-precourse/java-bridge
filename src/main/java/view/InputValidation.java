package view;

import constant.BridgeType;
import constant.Constant;
import constant.ErrorMessage;

public class InputValidation {

    public void checkBlank(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK);
        }
    }

    public void checkInteger(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER);
        }
    }

    public void checkBridgeSize(int bridgeSize) throws IllegalArgumentException {
        if (bridgeSize < Constant.MIN_BRIDGE_SIZE || bridgeSize > Constant.MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE);
        }
    }

    public void checkMoving(String input) throws IllegalArgumentException {
        if (!input.equals(BridgeType.UP) && !input.equals(BridgeType.DOWN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVING);
        }
    }

    public void checkGameCommand(String input) throws IllegalArgumentException {
        if (!input.equals(Constant.RETRY) && !input.equals(Constant.QUIT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_COMMAND);
        }
    }

}
