package bridge;

import java.util.regex.Pattern;

import static bridge.ErrorMessage.*;

public class ValidityCheck {

    public void stringChecker(String testObject) {
        Pattern zeroToNine = Pattern.compile("^[0-9]*$");
        if (!zeroToNine.matcher(testObject).matches()) {
            throw new IllegalArgumentException(ER_STRING.getMessage());
        }
    }

}

