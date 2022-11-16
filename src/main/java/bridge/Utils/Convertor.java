package bridge.Utils;

import static bridge.Utils.Validation.Validation.validateIsNumber;

public class Convertor {

    public static int stringToInt(String target) {
        validateIsNumber(target);
        return Integer.parseInt(target);
    }
}
