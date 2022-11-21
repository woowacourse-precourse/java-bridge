package bridge.util.validator;

import org.junit.platform.commons.util.StringUtils;

public final class BlankValidator {
    public static void isBlank(String words, String errorMessage) {
        if (StringUtils.isBlank(words)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
