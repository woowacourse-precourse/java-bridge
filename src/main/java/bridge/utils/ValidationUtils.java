package bridge.utils;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

import static bridge.exception.Errors.CANNOT_CHARACTER_FORMAT;
import static bridge.exception.Errors.EMPTY_INPUT;
import static bridge.exception.Errors.INPUT_RIGHT_RANGE;

public class ValidationUtils {

    private static final String NUMBER_REGEX = "^\\d+$";
    private static final int MINIMUM_BRIDGE_LENGTH = 3;
    private static final int MAXIMUM_BRIDGE_LENGTH = 20;

    private ValidationUtils() {
    }

    public static void validateBridgeSize(final String bridgeSize) {
        validateEmpty(bridgeSize);
        validateNumberFormat(bridgeSize);
        validateRange(bridgeSize);
    }

    private static void validateEmpty(final String bridgeSize) {
        if (isBlank(bridgeSize)) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private static boolean isBlank(final String bridgeSize) {
        return StringUtils.isBlank(bridgeSize);
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
}
