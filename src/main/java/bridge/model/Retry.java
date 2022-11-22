package bridge.model;

import java.util.HashMap;

import static bridge.exception.InputExceptionMessage.RETRY_INCORRECT_INPUT_EXCEPTION;

public class Retry {
    private static final HashMap<String, Boolean> bridge = new HashMap<String, Boolean>() {{
        put("R", true);
        put("Q", false);
    }};

    public static Boolean isRetry(final String symbol) {
        if (!bridge.containsKey(symbol)) {
            throw new IllegalArgumentException(RETRY_INCORRECT_INPUT_EXCEPTION.message());
        }
        return bridge.get(symbol);
    }
}
