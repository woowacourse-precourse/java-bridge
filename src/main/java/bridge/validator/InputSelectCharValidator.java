package bridge.validator;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputSelectCharValidator {
    private static final Map<Integer, String> inputSelectCharValidatorSort = new HashMap<>();
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String MOVING_SELECT_ERROR_MESSAGE = "U 또는 D 만 입력할 수 있습니다.";
    private static final int MOVING_SELECT_CHAR_VALIDATOR_NUMBER = 1;
    private static final int RETRY_SELECT_CHAR_VALIDATOR_NUMBER = 2;
    
    static {
        inputSelectCharValidatorSort.put(MOVING_SELECT_CHAR_VALIDATOR_NUMBER, "[U|D]");
        inputSelectCharValidatorSort.put(RETRY_SELECT_CHAR_VALIDATOR_NUMBER, "[Q|R]");
    }
    
    public static void validate(final String selectChar, final int selectCharValidatorNumber) {
        validateNullOrEmpty(selectChar);
        validateSelectCharFormMatch(selectChar, selectCharValidatorNumber);
    }
    
    private static void validateNullOrEmpty(final String selectChar) {
        InputCommonValidator.validate(selectChar);
    }
    
    private static void validateSelectCharFormMatch(final String selectChar, final int selectCharValidatorNumber) {
        if (isNotMatchSelectCharFormat(selectChar, selectCharValidatorNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + parseErrorMessage(selectCharValidatorNumber));
        }
    }
    
    private static String parseErrorMessage(final int selectCharValidatorNumber) {
        if (selectCharValidatorNumber == MOVING_SELECT_CHAR_VALIDATOR_NUMBER) {
            return MOVING_SELECT_ERROR_MESSAGE;
        }
        
        return null;
    }
    
    private static boolean isNotMatchSelectCharFormat(final String selectChar, final int selectCharValidatorNumber) {
        return !matcher(selectChar, inputSelectCharValidatorSort.get(selectCharValidatorNumber)).matches();
    }
    
    private static Matcher matcher(final String selectChar, final String correctInputForm) {
        return compiler(correctInputForm).matcher(selectChar);
    }
    
    private static Pattern compiler(final String correctInputForm) {
        return Pattern.compile(correctInputForm);
    }
}
