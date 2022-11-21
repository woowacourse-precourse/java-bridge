package bridge.verifier;

import bridge.domain.GameMoving;
import bridge.system.ExceptionMessage;

import java.util.regex.Pattern;

public class MovingVerifier {
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
        if (!GameMoving.isUp(target) && !GameMoving.isDown(target)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_UNDERSTANDABLE_COMMAND);
        }
    }
}
