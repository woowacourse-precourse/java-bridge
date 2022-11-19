package bridge.domain;

import java.util.HashMap;
import java.util.Map;

public class BridgeGameRepository {

    private static final String ROUND_KEY = "round";
    private static final String TRY_COUNT_KEY = "tryCount";
    private static final String FINAL_ROUND_KEY = "finalRound";

    private static final Integer ROUND_DEFAULT_VALUE = 1;
    private static final Integer TRY_COUNT_DEFAULT_VALUE = 1;

    private final Map<String, Integer> localDb = new HashMap<>();

    public void setBridgeGameInfo(int size) {
        localDb.put(ROUND_KEY, ROUND_DEFAULT_VALUE);
        localDb.put(TRY_COUNT_KEY, TRY_COUNT_DEFAULT_VALUE);
        localDb.put(FINAL_ROUND_KEY, size);
    }

    public int findRound() {
        return localDb.get(ROUND_KEY);
    }

    public int findTryCount() {
        return localDb.get(TRY_COUNT_KEY);
    }

    public void retry() {
        localDb.put(ROUND_KEY, ROUND_DEFAULT_VALUE);
        localDb.computeIfPresent(TRY_COUNT_KEY, (key, tryCount) -> tryCount + 1);
    }

    public boolean isFinalRound() {
        return localDb.get(ROUND_KEY).equals(localDb.get(FINAL_ROUND_KEY));
    }

    public void goToNextRound() {
        localDb.computeIfPresent(ROUND_KEY, (key, roundValue) -> roundValue + 1);
    }
}
