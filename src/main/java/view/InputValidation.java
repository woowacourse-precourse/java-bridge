package view;

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
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER);
        }
    }

    public void checkBridgeSize(int bridgeSize) throws IllegalArgumentException {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BRIDGE_SIZE);
        }
    }

    public void checkMoving(String input) throws IllegalArgumentException {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MOVING);
        }
    }

    public void checkGameCommand(String input) throws IllegalArgumentException {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GAME_COMMAND);
        }
    }

}
