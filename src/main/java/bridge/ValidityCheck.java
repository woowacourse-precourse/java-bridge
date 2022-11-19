package bridge;

import java.util.regex.Pattern;

public class ValidityCheck {

    private static final String ZEROTONINE = "^[0-9]*$";
    private static final int RANGE_MIN = 3;
    private static final int RANGE_MAX = 20;

    public static boolean stringChecker(String testObject) {
        Pattern zeroToNine = Pattern.compile(ZEROTONINE);
        if (!zeroToNine.matcher(testObject).matches()) {
            return false;
        }
        return true;
    }

    public static boolean numberRangeChecker(String testObject) {
        if (stringChecker(testObject)) {
            if (RANGE_MIN > Integer.parseInt(testObject) ||
                    Integer.parseInt(testObject) > RANGE_MAX) {
                return false;
            }
        }
        return true;
    }
}

