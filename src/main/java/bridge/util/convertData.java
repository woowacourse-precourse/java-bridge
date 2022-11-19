package bridge.util;

import static bridge.enums.ErrorMsg.*;

public class convertData {

    public static String mappingBridgeCellIntToString(int number) {
        String value = new String();

        if (number == 0) {
            value = "D";
        }
        if (number == 1) {
            value = "U";
        }

        return value;
    }

    public static int convertStringIntoInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            String errorMsg = ERROR_PREFIX.get() + ERROR_INPUT_VALUE_IS_NOT_NUMBER.get();
            System.out.println(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
    }
}
