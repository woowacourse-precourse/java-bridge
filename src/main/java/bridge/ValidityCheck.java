package bridge;

import java.util.regex.Pattern;

import static bridge.ErrorMessage.*;

public class ValidityCheck {

    public boolean stringChecker(String testObject) {
        Pattern zeroToNine = Pattern.compile("^[0-9]*$");
        if (!zeroToNine.matcher(testObject).matches()) {
            throw new IllegalArgumentException(ER_STRING.getMessage());
        }
        return true;
    }

    public boolean numberRangeChecker(String testObject) {
        if (stringChecker(testObject)) {
            if (Number.RANGE_MIN.getValue() > Integer.parseInt(testObject) ||
                    Integer.parseInt(testObject) > Number.RANGE_MAX.getValue()) {
                throw new IllegalArgumentException(ER_OUT_OF_RANGE.getMessage());
            }
        }
        return true;
    }

}

