package bridge.validate;

import static bridge.message.ErrorMessage.BUFFER_EMPTY;

public class UtilValidation {

    public static void validateBufferLength(StringBuffer stringBuffer) {
        if(stringBuffer.length() == 0) {
            throw new IllegalStateException(BUFFER_EMPTY.getMessage());
        }
    }
}
