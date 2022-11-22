package bridge.util;

import static bridge.constant.ErrorType.BRIDGE_RANGE_ERROR;
import static bridge.constant.ErrorType.GAME_COMMAND_ERROR;
import static bridge.constant.ErrorType.MOVING_INPUT_ERROR;

import bridge.constant.BridgeMove;
import bridge.constant.BridgeRange;
import bridge.constant.GameCommand;

public class Validator {

    public static void validateNumberInBridgeRange(int number) {
        if (isNumberNotInBridgeRange(number)) {
            throw new IllegalArgumentException(BRIDGE_RANGE_ERROR.getMessage());
        }
    }

    public static boolean isNumberNotInBridgeRange(int number) {
        int minRange = BridgeRange.MIN.getValue();
        int maxRange = BridgeRange.MAX.getValue();

        return !(minRange <= number && number <= maxRange);
    }

    public static void validateMovableInput(String input) {
        BridgeMove bridgeMove = BridgeMove.findByInput(input);

        if (bridgeMove.isMiss()) {
            throw new IllegalArgumentException(MOVING_INPUT_ERROR.getMessage());
        }
    }

    public static void validateIfStringIsGameCommand(String string) {
        GameCommand gameCommand = GameCommand.findByString(string);

        if (gameCommand.isMiss()) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR.getMessage());
        }
    }
}
