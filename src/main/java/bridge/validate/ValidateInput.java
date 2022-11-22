package bridge.validate;

import bridge.type.BridgeGameCommandType;
import bridge.type.BridgeSideType;

public class ValidateInput {

    private final static int MIN_BRIDGE_SIZE = 3;
    private final static int MAX_BRIDGE_SIZE = 20;

    public void validateInputBridgeSize(String input) {
        validateInputIsNumber(input);
        int number = Integer.parseInt(input);

        if (number < MIN_BRIDGE_SIZE || number > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputBridgeSide(String input) {
        if (input.equals(BridgeSideType.UPPER_SIDE.getSide()) || input.equals(BridgeSideType.LOWER_SIDE.getSide())) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public void validateInputGameCommand(String input) {
        if (input.equals(BridgeGameCommandType.RESTART.getGameCommand()) || input.equals(BridgeGameCommandType.QUIT.getGameCommand())) {
            return;
        }
        throw new IllegalArgumentException();
    }

    private void validateInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
