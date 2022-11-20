package bridge.util;

import static bridge.constant.ErrorType.NUMBER_ERROR;

public class TypeConversion {

    public static int stringToInt(String string) {

        int conversionValue;
        try {
            conversionValue = Integer.parseInt(string);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NUMBER_ERROR.getMessage());
        }

        return conversionValue;
    }
}
