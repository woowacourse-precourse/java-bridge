package bridge;

import java.util.regex.Pattern;

import static bridge.constants.ErrorMessage.ERROR_INVALID_NUMBER;
import static bridge.constants.ErrorMessage.ERROR_MESSAGE;

public class ValidationException {

    public static final int MAXIMUM_LENGTH = 20;
    public static final int MINIMUM_LENGTH = 3;

    public boolean checkValidNumber(String bridgeLength) throws IllegalArgumentException {
        String regExp = "\\d+";
        if (Pattern.matches(regExp, bridgeLength)){
            int length = Integer.parseInt(bridgeLength);
            if (length < MINIMUM_LENGTH || length > MAXIMUM_LENGTH) {
                throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_INVALID_NUMBER);
            }
            return true;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_INVALID_NUMBER);
    }
}
