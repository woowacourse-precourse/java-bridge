package bridge.model;

import java.util.regex.Pattern;

public class ValidityCheck {
    private static final String ZERO_TO_NINE = "^[0-9]*$";
    private static final int RANGE_MIN = 3;
    private static final int RANGE_MAX = 20;


    public boolean stringChecker(String testObject) {
        Pattern zeroToNine = Pattern.compile(ZERO_TO_NINE);
        return zeroToNine.matcher(testObject).matches();
    }

    public boolean numberRangeChecker(String testObject) {
        if (stringChecker(testObject)) {
            return RANGE_MIN <= Integer.parseInt(testObject) &&
                    Integer.parseInt(testObject) <= RANGE_MAX;
        }
        return true;
    }
}
