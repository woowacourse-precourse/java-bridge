package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class GameRecord {
    private final List<String> upperCrossedRecord;
    private final List<String> lowerCrossedRecord;
    private int tryCount;
    public GameRecord() {
        upperCrossedRecord = new ArrayList<>();
        lowerCrossedRecord = new ArrayList<>();
        this.tryCount = 1;
    }

    public void recordRetry() {
        tryCount += 1;
    }

    public int getTryCount() {
        return tryCount;
    }
}
