package bridge.validator;

import bridge.exception.UtilClassCreateException;
import bridge.utils.StringUtils;

public class InputCommonValidator {
    
    public static final String BLANK_INPUT_ERROR_MESSAGE = "[ERROR] Null 또는 empty 를 입력할 수 없습니다. 다시 입력해주세요";
    
    private InputCommonValidator() {
        throw new UtilClassCreateException();
    }
    
    public static void validate(final String inputBridgeSize) {
        if (StringUtils.isBlank(inputBridgeSize)) {
            throw new IllegalArgumentException(BLANK_INPUT_ERROR_MESSAGE);
        }
    }
}
