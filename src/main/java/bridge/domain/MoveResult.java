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

    public List<String> getCrossedStatus(String position) {
        if (position.equals(MoveCondition.UPPER.getPosition())) {
            return upperBridge.getCrossedBridge();
        }
        return lowerBridge.getCrossedBridge();
    }

    private void updateEachBridge(Boolean upperResult, Boolean lowerResult) {
        upperBridge.updateMoveResult(upperResult);
        lowerBridge.updateMoveResult(lowerResult);
    }
}
