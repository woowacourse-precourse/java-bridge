package bridge.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputBridgeSizeValidator {
    private static final String BRIDGE_SIZE_FORM_ERROR_MESSAGE = "[ERROR] '3~20 범위'의 '숫자'만 입력 가능합니다.";
    private static final String BRIDGE_SIZE_INPUT_FORM = "[3-9]|1\\d|20";
    
    public static void validate(final String inputBridgeSize) {
        validateNullOrEmpty(inputBridgeSize);
        validateInputtedBridgeSizeFormMatch(inputBridgeSize);
    }
    
    private static void validateNullOrEmpty(final String inputBridgeSize) {
        InputCommonValidator.validate(inputBridgeSize);
    }
    
    private static void validateInputtedBridgeSizeFormMatch(final String inputBridgeSize) {
        final Matcher matcher = Pattern.compile(BRIDGE_SIZE_INPUT_FORM).matcher(inputBridgeSize);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(BRIDGE_SIZE_FORM_ERROR_MESSAGE);
        }
    }
}
