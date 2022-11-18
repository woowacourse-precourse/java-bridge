package bridge.controller;

import bridge.bridge.Direction;

import java.util.HashMap;
import java.util.Map;

public enum GameResult {
    SUCCESS(true, "성공"),
    FAILURE(false, "실패"),
    ;

    private static final Map<Boolean, String> RESULT_VALUE = new HashMap<>();
    static {
        for (GameResult value : values()) {
            RESULT_VALUE.put(value.flag, value.result);
        }
    }

    private final boolean flag;
    private final String result;

    GameResult(boolean flag, String result) {
        this.flag = flag;
        this.result = result;
    }

    public static String convert(boolean flag) {
        return RESULT_VALUE.get(flag);
    }
}
