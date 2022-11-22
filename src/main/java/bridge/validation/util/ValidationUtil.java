package bridge.validation.util;

import static bridge.Bridge.INPUT_SIZE;
import static bridge.Bridge.MAX_BRIDGE_SIZE;
import static bridge.Bridge.MIN_BRIDGE_SIZE;
import static bridge.constant.mark.InputMark.DOWN;
import static bridge.constant.mark.InputMark.QUIT;
import static bridge.constant.mark.InputMark.RETRY;
import static bridge.constant.mark.InputMark.UP;

public class ValidationUtil {

    public static boolean isInteger(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean isWithinValidRange(String bridgeSize) {
        int input = Integer.parseInt(bridgeSize);

        return MIN_BRIDGE_SIZE <= input && input <= MAX_BRIDGE_SIZE;
    }

    public static boolean isOneCharacter(String input) {
        return input.length() == INPUT_SIZE;
    }

    public static boolean isValidMoving(String moving) {
        return moving.equals(UP.getMark()) || moving.equals(DOWN.getMark());
    }

    public static boolean isValidGameCommand(String gameCommand) {
        return gameCommand.equals(RETRY.getMark()) || gameCommand.equals(QUIT.getMark());
    }
}
