package bridge.validate;

import static bridge.message.ErrorMessage.BUFFER_EMPTY;
import static bridge.value.UtilValue.EMPTY_SIZE;

public class UtilValidation {

    public static void validateBufferLength(StringBuffer stringBuffer) {
        if(stringBuffer.length() == EMPTY_SIZE.getValue()) {
            throw new IllegalStateException(BUFFER_EMPTY.getMessage());
        }
    }
}
