package bridge.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameRecord {
    private final List<String> upperCrossedRecord;
    private final List<String> lowerCrossedRecord;
    private int tryCount;
    public GameRecord() {
        upperCrossedRecord = new ArrayList<>();
        lowerCrossedRecord = new ArrayList<>();
        this.tryCount = 1;
    }

    public void recordMove(String spaceToMove, boolean isDead) {
        String marker = isDead ? " X " : " O ";
        if (spaceToMove.equals("U")) {
            upperCrossedRecord.add(marker);
            lowerCrossedRecord.add("   ");
            return;
        }
        upperCrossedRecord.add("   ");
        lowerCrossedRecord.add(marker);
    }

    public void recordRetry() {
        tryCount += 1;
        clearCrossedRecord();
    }

    private void clearCrossedRecord() {
        upperCrossedRecord.clear();
        lowerCrossedRecord.clear();
    }

    public int getTryCount() {
        return tryCount;
    }

    public Map<String, List<String>> getCrossedRecord() {
        Map<String, List<String>> crossedRecord = new HashMap<>();
        crossedRecord.put("upperCrossedRecord", upperCrossedRecord);
        crossedRecord.put("lowerCrossedRecord", lowerCrossedRecord);
        return crossedRecord;
    }
}
