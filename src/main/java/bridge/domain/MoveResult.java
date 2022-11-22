package bridge.domain;

import bridge.domain.bridgeenum.MovePosition;
import java.util.List;

public class MoveResult {
    private final CrossedBridge upperBridge;
    private final CrossedBridge lowerBridge;

    public MoveResult() {
        upperBridge = new CrossedBridge();
        lowerBridge = new CrossedBridge();
    }

    public void updateMoveResult(boolean isSuccess, String position) {
        if (position.equals(MovePosition.UPPER.getPosition())) {
            updateEachBridge(isSuccess, null);
        }
        if (position.equals(MovePosition.LOWER.getPosition())) {
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

    public int getNextMoveIndex() {
        return upperBridge.getSize();
    }

    private void updateEachBridge(Boolean upperResult, Boolean lowerResult) {
        upperBridge.updateMoveResult(upperResult);
        lowerBridge.updateMoveResult(lowerResult);
    }
}
