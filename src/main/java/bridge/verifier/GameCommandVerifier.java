package bridge.verifier;

import bridge.domain.GameControl;
import bridge.system.ExceptionMessage;

import java.util.regex.Pattern;

public class GameCommandVerifier {
    private final String ALPHABET_PATTERN = "^[a-zA-Z]*$";

    public void check(String target) {
        isNotAlphabetic(target);
        isNotUnderstandable(target);
    }

    private void isNotAlphabetic(String target) {
        if (!Pattern.matches(ALPHABET_PATTERN, target)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_ALPHABETIC);
        }
    }

    private void isNotUnderstandable(String target) {
        if (!GameControl.isRetry(target) && !GameControl.isQuit(target)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_UNDERSTANDABLE_COMMAND);
        }
    }
}
