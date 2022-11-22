package bridge;

import java.util.LinkedHashMap;
import java.util.Map;

public class JudgeMovingResult {

    private final String POSSIBLE = "O";
    private final String IMPOSSIBLE = "X";

    public String isMovingPossible(String moving, String bridgeDirection) {
        if (moving.equals(bridgeDirection)) {
            return POSSIBLE;
        }
        return IMPOSSIBLE;
    }

    public Map<String, String> recordMoving(String moving, String result) {
        Map<String, String> movingRecord = new LinkedHashMap<>();

        for (BridgeDirection direction : BridgeDirection.values()) {
            movingRecord.put(direction.getDirection(), " ");
        }
        movingRecord.replace(moving, result);
        return movingRecord;
    }
}
