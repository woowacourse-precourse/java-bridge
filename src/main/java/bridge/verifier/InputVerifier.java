package bridge.verifier;

import bridge.constant.Bridge;
import bridge.constant.ExceptionMessage;
import bridge.constant.GameCommand;
import bridge.constant.Moving;

public class InputVerifier {
    public static void BridgeSize(String bridgeSize) {
        if (!bridgeSize.matches(Bridge.REGEX__RANGE)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_BRIDGE_LENGTH);
        }
    }

    public static void moving(String moving) {
        if (!(moving.equals(Moving.UP) || moving.equals(Moving.DOWN))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MOVING);
        }
    }

    public static void gameCommand(String gameCommand) {
        if (!(gameCommand.equals(GameCommand.RESTART) || gameCommand.equals(GameCommand.QUIT))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_GAME_COMMAND);
        }
    }

}
