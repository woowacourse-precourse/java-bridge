package bridge.domain;

import bridge.util.constants.Marker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bridge.util.constants.RecordKey.UPPER_RECORD_KEY;
import static bridge.util.constants.RecordKey.LOWER_RECORD_KEY;
import static bridge.util.constants.MovableSpace.UPPER_SPACE;
import static bridge.util.constants.Marker.NOT_CROSS;

public class GameRecord {
    private final Map<String, List<String>> crossedRecord;
    private int tryCount;

    public GameRecord() {
        crossedRecord = new HashMap<>();
        crossedRecord.put(UPPER_RECORD_KEY.getValue(), new ArrayList<>());
        crossedRecord.put(LOWER_RECORD_KEY.getValue(), new ArrayList<>());
        this.tryCount = 1;
    }

    public void recordMove(String spaceToMove, boolean isDead) {
        String marker = Marker.getMarker(isDead);
        if (spaceToMove.equals(UPPER_SPACE.getValue())) {
            recordCrossedUpper(marker);
            return;
        }
        recordCrossedLower(marker);
    }

    private void recordCrossedUpper(String marker) {
        List<String> upperCrossedRecord = crossedRecord.get(UPPER_RECORD_KEY.getValue());
        List<String> lowerCrossedRecord = crossedRecord.get(LOWER_RECORD_KEY.getValue());

        upperCrossedRecord.add(marker);
        lowerCrossedRecord.add(NOT_CROSS.getValue());
    }

    private void recordCrossedLower(String marker) {
        List<String> upperCrossedRecord = crossedRecord.get(UPPER_RECORD_KEY.getValue());
        List<String> lowerCrossedRecord = crossedRecord.get(LOWER_RECORD_KEY.getValue());

        upperCrossedRecord.add(NOT_CROSS.getValue());
        lowerCrossedRecord.add(marker);
    }

    public void recordRetry() {
        tryCount += 1;
        clearCrossedRecord();
    }

    private void clearCrossedRecord() {
        List<String> upperCrossedRecord = crossedRecord.get(UPPER_RECORD_KEY.getValue());
        List<String> lowerCrossedRecord = crossedRecord.get(LOWER_RECORD_KEY.getValue());

        upperCrossedRecord.clear();
        lowerCrossedRecord.clear();
    }

    public int getTryCount() {
        return tryCount;
    }

    public Map<String, List<String>> getCrossedRecord() {
        return crossedRecord;
    }
}
