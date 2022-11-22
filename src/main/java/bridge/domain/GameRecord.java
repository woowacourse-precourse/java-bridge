package bridge.domain;

import bridge.util.constants.Marker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static bridge.util.constants.RecordKey.UPPER_RECORD_KEY;
import static bridge.util.constants.RecordKey.LOWER_RECORD_KEY;
import static bridge.util.constants.MovableSpace.UPPER_SPACE;
import static bridge.util.constants.MovableSpace.LOWER_SPACE;
import static bridge.util.constants.Marker.NOT_SELECTED;

public class GameRecord {
    private static final int INITIAL_TRY_COUNT = 1;
    private final Map<String, List<String>> crossedRecord;
    private int tryCount;

    public GameRecord() {
        crossedRecord = new HashMap<>();
        crossedRecord.put(UPPER_RECORD_KEY.getValue(), new ArrayList<>());
        crossedRecord.put(LOWER_RECORD_KEY.getValue(), new ArrayList<>());
        tryCount = INITIAL_TRY_COUNT;
    }

    public void recordMove(String spaceToMove, boolean isDead) {
        recordCrossedUpper(spaceToMove, isDead);
        recordCrossedLower(spaceToMove, isDead);
    }

    private void recordCrossedUpper(String spaceToMove, boolean isDead) {
        String marker = NOT_SELECTED.getValue();
        List<String> upperCrossedRecord = crossedRecord.get(UPPER_RECORD_KEY.getValue());
        if (spaceToMove.equals(UPPER_SPACE.getValue())) {
            marker = Marker.getCrossedMarker(isDead);
        }
        upperCrossedRecord.add(marker);
    }

    private void recordCrossedLower(String spaceToMove, boolean isDead) {
        String marker = NOT_SELECTED.getValue();
        List<String> lowerCrossedRecord = crossedRecord.get(LOWER_RECORD_KEY.getValue());
        if (spaceToMove.equals(LOWER_SPACE.getValue())) {
            marker = Marker.getCrossedMarker(isDead);
        }
        lowerCrossedRecord.add(marker);
    }

    public void recordRetry() {
        increaseTryCount();
        clearCrossedRecord();
    }

    private void increaseTryCount() {
        tryCount += 1;
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
