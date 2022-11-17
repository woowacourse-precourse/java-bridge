package bridge.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputBridgeSizeValidator {
    private static final String EXIST_ZERO_AT_FIRST_PLACE_EXCEPTION_MESSAGE = "[ERROR] 1번째 자리에는 0이 올 수 없습니다.";
    private static final String BRIDGE_SIZE_FORM_ERROR_MESSAGE = "[ERROR] '3~20 범위'의 '숫자'만 입력 가능합니다.";
    private static final String EXIST_ZERO_AT_FIRST_PLACE_FORM = "0\\d+";
    private static final String BRIDGE_SIZE_INPUT_FORM = "[3-9]|1\\d|20";
    
    public static void validate(final String inputBridgeSize) {
        validateNullOrEmpty(inputBridgeSize);
        validateZeroAtFirstPlaceExist(inputBridgeSize);
        validateInputtedBridgeSizeFormMatch(inputBridgeSize);
    }
    
    private static void validateNullOrEmpty(final String inputBridgeSize) {
        InputCommonValidator.validate(inputBridgeSize);
    }
    
    private static void validateZeroAtFirstPlaceExist(final String inputNumber) {
        if (isExistZeroAtFirstPlace(inputNumber)) {
            throw new IllegalArgumentException(EXIST_ZERO_AT_FIRST_PLACE_EXCEPTION_MESSAGE);
        }
    }
    
    private static boolean isExistZeroAtFirstPlace(final String inputNumber) {
        return matcher(inputNumber, EXIST_ZERO_AT_FIRST_PLACE_FORM).matches();
    }
    
    private static void validateInputtedBridgeSizeFormMatch(final String inputBridgeSize) {
        if (isNotMatchInputFormat(inputBridgeSize)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_FORM_ERROR_MESSAGE);
        }
    }
    
    private static boolean isNotMatchInputFormat(final String inputBridgeSize) {
        return !matcher(inputBridgeSize, BRIDGE_SIZE_INPUT_FORM).matches();
    }
    
    private static Matcher matcher(final String inputNumber, final String correctInputForm) {
        return compiler(correctInputForm).matcher(inputNumber);
    }
    
    private static Pattern compiler(final String correctInputForm) {
        return Pattern.compile(correctInputForm);
    }
}
