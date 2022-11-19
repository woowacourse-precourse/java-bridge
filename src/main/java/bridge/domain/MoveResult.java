package bridge.domain;

import bridge.domain.bridgeenum.MoveCondition;
import java.util.List;

public class MoveResult {
    private final CrossedBridge upperBridge;
    private final CrossedBridge lowerBridge;

    public MoveResult() {
        upperBridge = new CrossedBridge();
        lowerBridge = new CrossedBridge();
    }

    public void updateMoveResult(boolean isSuccess, String position) {
        if (position.equals(MoveCondition.UPPER.getPosition())) {
            updateEachBridge(isSuccess, null);
        }
        if (position.equals(MoveCondition.LOWER.getPosition())) {
            updateEachBridge(null, isSuccess);
        }
    }

    public List<List<String>> getMap() {
        return List.of(upperBridge.getCrossedBridge(), lowerBridge.getCrossedBridge());
    }

    public void clearResult() {
        upperBridge.initialize();
        lowerBridge.initialize();
    }

    private void updateEachBridge(Boolean upperResult, Boolean lowerResult) {
        upperBridge.updateMoveResult(upperResult);
        lowerBridge.updateMoveResult(lowerResult);
    }
}
