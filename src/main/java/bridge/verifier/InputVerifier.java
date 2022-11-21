package bridge.verifier;

import bridge.constant.ExceptionMessage;
import bridge.constant.Moving;

public class InputVerifier {
    private static final String REGEX_BRIDGE_SIZE_RANGE = "^[3-9]{1}$|^1{1}[0-9]{1}$|^2{1}0{1}$";
    private static final String GameCommand_RESTART = "R";
    private static final String GameCommand_QUIT = "Q";

    public static void BridgeSize(String bridgeSize) {
        if (!bridgeSize.matches(REGEX_BRIDGE_SIZE_RANGE)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_BRIDGE_LENGTH);
        }
    }

    public static void moving(String moving) {
        if (!(moving.equals(Moving.UP) || moving.equals(Moving.DOWN))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_MOVING);
        }
    }

    public static void gameCommand(String gameCommand) {
        if (!(gameCommand.equals(GameCommand_RESTART) || gameCommand.equals(GameCommand_QUIT))) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_GAME_COMMAND);
        }
    }

}
