package bridge.utils;

import bridge.constant.BridgePhrase;

public class EmptyAndNullChecker {

    public static void check(final String input) {
        try {
            if (input.isBlank()) {
                throw new IllegalArgumentException(BridgePhrase.ERROR_PARSER_BLANK.getMessage());
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(BridgePhrase.ERROR_PARSER_NULL.getMessage());
        }
    }
}
