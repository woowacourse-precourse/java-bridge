package bridge;

import bridge.enums.Number;

import java.util.regex.Pattern;

public class ValidityCheck {

    private static final String ZEROTONINE = "^[0-9]*$";
    public static boolean stringChecker(String testObject) {
        Pattern zeroToNine = Pattern.compile(ZEROTONINE);
        if (!zeroToNine.matcher(testObject).matches()) {
            return false;
        }
        return true;
    }

    public static boolean numberRangeChecker(String testObject) {
        if (stringChecker(testObject)) {
            if (Number.RANGE_MIN.getValue() > Integer.parseInt(testObject) ||
                    Integer.parseInt(testObject) > Number.RANGE_MAX.getValue()) {
                return false;
            }
        }
        return true;
    }
}

