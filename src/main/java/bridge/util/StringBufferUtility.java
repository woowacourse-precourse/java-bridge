package bridge.util;

import static bridge.validate.UtilValidation.validateBufferLength;

public class StringBufferUtility {

    public static void popLastCharacter(StringBuffer stringBuffer) {
        validateBufferLength(stringBuffer);

        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
    }
}
