package bridge.verifier;

import bridge.system.ExceptionMessage;

import java.util.regex.Pattern;

public class GameCommandVerifier {
    private String alphabetPattern = "^[a-zA-Z]*$";

    public void check(String target) {
        isNotAlphabetic(target);
        isNotUnderstandable(target);
    }

    private void isNotAlphabetic(String target) {
        if (!Pattern.matches(target, alphabetPattern)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_ALPHABETIC);
        }
    }

    private void isNotUnderstandable(String target) {
        if (target.equals("R") || target.equals("Q")) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_UNDERSTANDABLE_COMMAND);
        }
    }
}
