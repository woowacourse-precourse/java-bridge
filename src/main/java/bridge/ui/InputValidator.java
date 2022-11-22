package bridge.ui;

import static bridge.domain.BridgeConstants.DOWN;
import static bridge.domain.BridgeConstants.QUIT;
import static bridge.domain.BridgeConstants.RETRY;
import static bridge.domain.BridgeConstants.UP;

public class InputValidator {
    private static final int SIZE_LIMIT_START = 3;
    private static final int SIZE_LIMIT_END = 20;

    public static boolean isInputBlank(String input){
        return input.isBlank();
    }

    public static boolean isValidBridge(String bridgeSize){
        return isNumeric(bridgeSize) && isValidInRange(bridgeSize);
    }

    private static boolean isNumeric(String bridgeSize) {
        return bridgeSize.chars().allMatch(Character::isDigit);
    }

    private static boolean isValidInRange(String bridgeSize) {
        return SIZE_LIMIT_START <= Integer.parseInt(bridgeSize) && Integer.parseInt(bridgeSize) <= SIZE_LIMIT_END;
    }

    public static boolean isValidMove(String move){
        if (move.equals(UP) || move.equals(DOWN)){
            return true;
        }
        return false;
    }

    public static boolean isValidCmd(String cmd){
        if (cmd.equals(RETRY) || cmd.equals(QUIT)){
            return true;
        }
        return false;
    }

}
