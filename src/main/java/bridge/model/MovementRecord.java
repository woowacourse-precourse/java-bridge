package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class MovementRecord {
    private final List<SpotInfo> movementMap;

    public MovementRecord() {
        movementMap = new ArrayList<>();
    }

    public SpotInfo getMovementRecord(int index) {
        return movementMap.get(index - 1);
    }

    public int getMovementCount() {
        return movementMap.size();
    }

    public void addMovementRecord(SpotInfo spotInfo) {
        movementMap.add(spotInfo);
    }

    public void clearMovementRecord() {
        movementMap.clear();
    }
}
