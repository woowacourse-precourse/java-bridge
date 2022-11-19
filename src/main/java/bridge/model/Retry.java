package bridge.model;

import java.util.HashMap;

public class Retry {
    private static final HashMap<String, Boolean> bridge = new HashMap<String, Boolean>() {{
        put("R", true);
        put("Q", false);
    }};

    public static Boolean isRetry(final String symbol) {
        return bridge.get(symbol);
    }
}
