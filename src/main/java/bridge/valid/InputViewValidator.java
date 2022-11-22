package bridge.valid;

import java.util.regex.Pattern;

public class InputViewValidator {

    public static final String NUMBER_REGEX = "^[0-9]*$";
    public static final String ERROR_INVALID_BRIDGE_NUMBER = "[ERROR] 다리의 길이는 숫자이어야 합니다.";

    private InputViewValidator() {
    }

    public static void validate(String size) {
        validateIsNumber(size);
        BridgeValidator.validateSize(Integer.parseInt(size));
    }

    private static void validateIsNumber(String size) {
        if (!isNumber(size)) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_NUMBER);
        }
    }

    private static boolean isNumber(String size) {
        return Pattern.matches(NUMBER_REGEX, size);
    }
}
