package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MovementRecord {
    private final List<BridgeLane> movementMap;

    public MovementRecord() {
        movementMap = new ArrayList<>();
    }

    public BridgeLane getMovementAtPosition(int position) {
        return movementMap.get(position - 1);
    }

    public int getMovementCount() {
        return movementMap.size();
    }

    public void addMovement(BridgeLane bridgeLane) {
        movementMap.add(bridgeLane);
    }

    public void clearMovementRecord() {
        movementMap.clear();
    }
}
