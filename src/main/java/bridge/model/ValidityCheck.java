package bridge.model;

import java.util.regex.Pattern;

public class ValidityCheck {
    private static final String ZERO_TO_NINE = "^[0-9]*$";

    public boolean stringChecker(String testObject) {
        Pattern zeroToNine = Pattern.compile(ZERO_TO_NINE);
        return zeroToNine.matcher(testObject).matches();
    }
}
