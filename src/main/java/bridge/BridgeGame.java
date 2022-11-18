package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final String MOVABLE = "O ";
    private final String UNMOVABLE = "X ";
    private final String SPLIT_BY = "| ";
    private final String SPACE = "  ";

    private StringBuilder initialUpBridge;
    private StringBuilder initialDownBridge;
    private BridgeRandomNumberGenerator bridgeRandomNumberGenerator;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String sideToMove, List<String> bridge, int blockCount) {
        initialUpBridge = new BridgeMaker(bridgeRandomNumberGenerator).makeInitialBridge();
        initialDownBridge = new BridgeMaker(bridgeRandomNumberGenerator).makeInitialBridge();
        moveUp(sideToMove, bridge, blockCount);
        moveDown(sideToMove, bridge, blockCount);
    }

    public void moveUp(String sideToMove, List<String> bridge, int blockCount) {
        if (sideToMove.equals("U") ) {
            if (bridge.get(blockCount).equals("U")) {
                initialUpBridge.insert(blockCount, MOVABLE);
                initialDownBridge.insert(blockCount, SPACE);
            }
        }
    }

    public void moveDown(String sideToMove, List<String> bridge, int blockCount) {
        if (sideToMove.equals("D") ) {
            if (bridge.get(blockCount).equals("D")) {
                initialDownBridge.insert(blockCount, MOVABLE);
                initialUpBridge.insert(blockCount, SPACE);
            }
        }
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}