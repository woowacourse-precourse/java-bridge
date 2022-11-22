package view;

import static bridge.enums.ErrorMessages.BRIDGE_SIZE_ERROR_MESSAGE;
import static bridge.enums.ErrorMessages.GAME_COMMAND_ERROR_MESSAGE;
import static bridge.enums.ErrorMessages.MOVING_DIRECTION_ERROR_MESSAGE;
import static bridge.enums.Range.ENDING_POINT_INCLUSIVE;
import static bridge.enums.Range.STARTING_POINT_INCLUSIVE;
import static bridge.enums.Regex.BRIDGE_SIZE_REGEX;
import static bridge.enums.Regex.GAME_COMMAND_REGEX;
import static bridge.enums.Regex.MOVING_DIRECTION_REGEX;

import java.util.regex.Pattern;

public class InputValidator {

    public InputValidator() {
    }

    public static void validateSize(String size) {
        if (size.length() > ENDING_POINT_INCLUSIVE.toString().length() ||
                !Pattern.matches(BRIDGE_SIZE_REGEX.toString(), size)
                || !isValidateSize(size)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_ERROR_MESSAGE.toString());
        }
    }

    public static void validateDirection(String direction) {
        if (!Pattern.matches(MOVING_DIRECTION_REGEX.toString(), direction)) {
            throw new IllegalArgumentException(MOVING_DIRECTION_ERROR_MESSAGE.toString());
        }
    }

    public static void validateCommand(String command) {
        if (!Pattern.matches(GAME_COMMAND_REGEX.toString(), command)) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR_MESSAGE.toString());
        }
    }

    private static boolean isValidateSize(String size) {
        int bridgeSize = Integer.parseInt(size);
        return (bridgeSize >= STARTING_POINT_INCLUSIVE.getPoint()
                && bridgeSize <= ENDING_POINT_INCLUSIVE.getPoint());
    }
}
