package bridge.verifier;

import bridge.system.ExceptionMessage;

import java.util.regex.Pattern;

public class MovingVerifier {
    private final String alphabetPattern = "^[a-zA-Z]*$";

    public void check(String target) {
        isNotAlphabetic(target);
        isNotUnderstandable(target);
    }

    public void isNotUnderstandable(String target) {
        if (!target.equals("U") && !target.equals("D")) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_UNDERSTANDABLE_COMMAND);
        }
    }

    private void isNotAlphabetic(String target) {
        if (!Pattern.matches(alphabetPattern, target)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_ALPHABETIC);
        }
    }
}
