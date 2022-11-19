package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final String MOVABLE = "O ";
    private final String UNMOVABLE = "X ";
    private final String SPLIT_BY = "| ";
    private final String SPACE = "  ";
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private StringBuilder initialUpBridge =
            new BridgeMaker(bridgeRandomNumberGenerator).makeInitialBridge();
    private StringBuilder initialDownBridge =
            new BridgeMaker(bridgeRandomNumberGenerator).makeInitialBridge();
    private List<String> moveBridgeResult = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public List<String> move(List<String> bridge, int tryCount, String sideToMove) {
        isBridgeLengthMoreThan5(tryCount);
        moveUp(sideToMove, bridge, tryCount);
        moveDown(sideToMove, bridge, tryCount);
        moveBridgeResult.add(initialUpBridge.toString());
        moveBridgeResult.add(initialDownBridge.toString());
        return moveBridgeResult;
    }

    public void moveUp(String sideToMove, List<String> bridge, int tryCount) {
        if (sideToMove.equals("U")) {
            if (bridge.get(tryCount).equals("U")) {
                int lastIndex = initialUpBridge.length() - 1;
                initialUpBridge.insert(lastIndex, MOVABLE);
                initialDownBridge.insert(lastIndex, SPACE);
            }
            if (bridge.get(tryCount).equals("D")) {
                int lastIndex = initialUpBridge.length() - 1;
                initialUpBridge.insert(lastIndex, UNMOVABLE);
                initialDownBridge.insert(lastIndex, SPACE);
            }
        }
    }

    public void moveDown(String sideToMove, List<String> bridge, int tryCount) {
        if (sideToMove.equals("D")) {
            if (bridge.get(tryCount).equals("D")) {
                int lastIndex = initialDownBridge.length() - 1;
                initialDownBridge.insert(lastIndex, MOVABLE);
                initialUpBridge.insert(lastIndex, SPACE);
            }
            if (bridge.get(tryCount).equals("U")) {
                int lastIndex = initialDownBridge.length() - 1;
                initialDownBridge.insert(lastIndex, UNMOVABLE);
                initialUpBridge.insert(lastIndex, SPACE);
            }
        }
    }

    public void isBridgeLengthMoreThan5(int tryCount) {
        if (tryCount > 0) {
            int lastIndex = initialUpBridge.length() - 1;
            initialUpBridge.insert(lastIndex, SPLIT_BY);
            initialDownBridge.insert(lastIndex, SPLIT_BY);
        }
    }

    public boolean isGameFailed() {
        if (initialUpBridge.toString().contains(UNMOVABLE)) {
            return true;
        }
        if (initialDownBridge.toString().contains(UNMOVABLE)) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}