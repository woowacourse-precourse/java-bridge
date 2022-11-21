package bridge.game;

import java.util.HashMap;
import java.util.Map;

public enum Result {
    SUCCESS(true, "성공"),
    FAILURE(false, "실패"),
    ;

    private static final Map<Boolean, String> RESULT_VALUE = new HashMap<>();
    static {
        for (Result value : values()) {
            RESULT_VALUE.put(value.flag, value.result);
        }
    }

    private final boolean flag;
    private final String result;

    Result(boolean flag, String result) {
        this.flag = flag;
        this.result = result;
    }

    public static String convert(boolean flag) {
        return RESULT_VALUE.get(flag);
    }
}
