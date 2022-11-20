package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MovementRecord {
    private final List<BridgeLane> movementMap;

    public MovementRecord() {
        movementMap = new ArrayList<>();
    }

    public BridgeLane getMovementRecord(int index) {
        return movementMap.get(index - 1);
    }

    public int getMovementCount() {
        return movementMap.size();
    }

    public void addMovementRecord(BridgeLane spotInfo) {
        movementMap.add(spotInfo);
    }

    public void clearMovementRecord() {
        movementMap.clear();
    }
}
