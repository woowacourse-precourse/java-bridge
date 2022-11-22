package bridge.utils;

import bridge.model.BridgePosition;
import bridge.model.GameCommand;
import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

import static bridge.exception.Errors.CANNOT_CHARACTER_FORMAT;
import static bridge.exception.Errors.EMPTY_INPUT;
import static bridge.exception.Errors.INPUT_RIGHT_RANGE;
import static bridge.exception.Errors.NOT_RIGHT_GAME_COMMAND;
import static bridge.exception.Errors.NOT_RIGHT_MOVE_COMMAND;

public class ValidationUtils {

    private static final String NUMBER_REGEX = "^\\d+$";
    private static final String MOVE_COMMAND_REGEX = "["
            + BridgePosition.BRIDGE_POSITION_UP.getCommand()
            + "|"
            + BridgePosition.BRIDGE_POSITION_DOWN.getCommand()
            + "]";
    private static final String GAME_COMMAND_REGEX = "["
            + GameCommand.RETRY.getSign()
            + "|"
            + GameCommand.QUIT.getSign()
            + "]";
    private static final int MAXIMUM_BRIDGE_LENGTH = 20;
    private static final int MINIMUM_BRIDGE_LENGTH = 3;

    private ValidationUtils() {
    }

    public static void validateBridgeSize(final String bridgeSize) {
        validateEmpty(bridgeSize);
        validateNumberFormat(bridgeSize);
        validateRange(bridgeSize);
    }

    private static void validateNumberFormat(final String bridgeSize) {
        if (isContainCharacter(bridgeSize)) {
            throw new IllegalArgumentException(CANNOT_CHARACTER_FORMAT.getMessage());
        }
    }

    private static boolean isContainCharacter(final String bridgeSize) {
        return !Pattern.matches(NUMBER_REGEX, bridgeSize);
    }

    private static void validateRange(final String bridgeSize) {
        int size = Integer.parseInt(bridgeSize);
        if (isRightRange(size)) {
            throw new IllegalArgumentException(INPUT_RIGHT_RANGE.getMessage());
        }
    }

    private static boolean isRightRange(final int size) {
        return size < MINIMUM_BRIDGE_LENGTH || size > MAXIMUM_BRIDGE_LENGTH;
    }

    public static void validateMove(final String move) {
        validateEmpty(move);
        validateRightMoveCommand(move);
    }

    private static boolean isDifferentMoveCommand(final String move) {
        return !Pattern.matches(MOVE_COMMAND_REGEX, move);
    }

    private static void validateRightMoveCommand(final String move) {
        if (isDifferentMoveCommand(move)) {
            throw new IllegalArgumentException(NOT_RIGHT_MOVE_COMMAND.getMessage());
        }
    }

    public static void validateGameCommand(final String command) {
        validateEmpty(command);
        validateRightGameCommand(command);
    }

    private static void validateEmpty(final String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private static boolean isBlank(final String input) {
        return StringUtils.isBlank(input);
    }

    private static void validateRightGameCommand(final String command) {
        if (isDifferentGameCommand(command)) {
            throw new IllegalArgumentException(NOT_RIGHT_GAME_COMMAND.getMessage());
        }
    }

    private static boolean isDifferentGameCommand(final String command) {
        return !Pattern.matches(GAME_COMMAND_REGEX, command);
    }
}
