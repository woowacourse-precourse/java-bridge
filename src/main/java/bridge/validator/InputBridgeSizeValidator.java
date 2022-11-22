package bridge.validator;

import bridge.exception.UtilClassCreateException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputBridgeSizeValidator {
    private static final String EXIST_ZERO_AT_FIRST_PLACE_EXCEPTION_MESSAGE = "[ERROR] 1번째 자리에는 0이 올 수 없습니다.";
    private static final String BRIDGE_SIZE_FORM_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String EXIST_ZERO_AT_FIRST_PLACE_FORM = "0\\d+";
    private static final String BRIDGE_SIZE_INPUT_FORM = "[3-9]|1\\d|20";
    
    private InputBridgeSizeValidator() {
        throw new UtilClassCreateException();
    }
    
    public static void validate(final String inputBridgeSize) {
        validateNullOrEmpty(inputBridgeSize);
        validateZeroAtFirstPlaceExist(inputBridgeSize);
        validateBridgeSizeFormMatch(inputBridgeSize);
    }
    
    private static void validateNullOrEmpty(final String bridgeSize) {
        InputCommonValidator.validate(bridgeSize);
    }
    
    private static void validateZeroAtFirstPlaceExist(final String bridgeSize) {
        if (isExistZeroAtFirstPlace(bridgeSize)) {
            throw new IllegalArgumentException(EXIST_ZERO_AT_FIRST_PLACE_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isExistZeroAtFirstPlace(final String bridgeSize) {
        return matcher(bridgeSize, EXIST_ZERO_AT_FIRST_PLACE_FORM).matches();
    }
    
    private static void validateBridgeSizeFormMatch(final String bridgeSize) {
        if (isNotMatchInputFormat(bridgeSize)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_FORM_ERROR_MESSAGE);
        }
    }
    
    private static boolean isNotMatchInputFormat(final String bridgeSize) {
        return !matcher(bridgeSize, BRIDGE_SIZE_INPUT_FORM).matches();
    }
    
    private static Matcher matcher(final String bridgeSize, final String correctInputForm) {
        return compiler(correctInputForm).matcher(bridgeSize);
    }
    
    private static Pattern compiler(final String correctInputForm) {
        return Pattern.compile(correctInputForm);
    }
}
