package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final String MOVABLE = "O ";
    private final String UNMOVABLE = "X ";
    private final String SPACE = "| ";

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public StringBuilder move(List<String> bridge, String sideToMove,
                              StringBuilder initialBridge) {
        int lastIndex = initialBridge.length() - 1;
        if (isCrossBridge(bridge, sideToMove)) {
            initialBridge.insert(lastIndex, MOVABLE);
            initialBridge = isBridgeLengthMoreThan5(initialBridge);
        }
        if (!isCrossBridge(bridge, sideToMove)) {
            initialBridge.insert(lastIndex, UNMOVABLE);
            initialBridge = isBridgeLengthMoreThan5(initialBridge);
        }
        return initialBridge;
    }

    public StringBuilder isBridgeLengthMoreThan5(StringBuilder initialBridge) {
        int bridgeLength = initialBridge.length();
        if (bridgeLength > 5) {
            int lastIndex = initialBridge.length() - 1;
            initialBridge.insert(lastIndex, SPACE);
        }
        return initialBridge;
    }

    public boolean isCrossBridge(List<String> bridge, String sideToMove) {
        for (int index = 0; index < bridge.size(); index++) {
            String block = bridge.get(index);
            if (block == sideToMove) {
                return true;
            }
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