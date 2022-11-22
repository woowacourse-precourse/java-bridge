package bridge.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum GameResult {
    SUCCESS(true, "성공"),
    FAIL(false, "실패"),
    ;

    private final boolean status;
    private final String statusMessage;

    private final static Map<Boolean, String> statusMap = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(e -> statusMap.put(e.status, e.statusMessage));
    }

    GameResult(boolean status, String statusMessage) {
        this.status = status;
        this.statusMessage = statusMessage;
    }

    public static String getGameResultMessage(final boolean result) {
        return statusMap.get(result);
    }
}
