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
            updateEachBridge(isSuccess, null); //null 하드코딩 하지 말고 MovePosition 내에서 하나가 값이 있으면 다른건 공백을 return -> 그 파라미터 순서대로 updateEachBridge
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

    private void updateEachBridge(Boolean upperResult, Boolean lowerResult) {
        upperBridge.updateMoveResult(upperResult);
        lowerBridge.updateMoveResult(lowerResult);
    }
}
