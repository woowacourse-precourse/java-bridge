package bridge.service;

import java.util.List;

import bridge.domain.BridgeResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeResult resultBridge;

    public BridgeGame(BridgeResult resultBridge) {
        this.resultBridge = resultBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String blockToMove, int blockPosition, List<String> bridge) {
        String block = bridge.get(blockPosition);

        if (blockToMove.equals(block)) {
            resultBridge.addBlock(blockToMove, "O");
            return "O";
        }

        resultBridge.addBlock(blockToMove, "X");
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (command.equals("R")) {
            return true;
        }
        return false;
    }

    public String getResultBridge() {
        return resultBridge.toString();
    }

    public void initialize() {
        resultBridge.clear();
    }

    public boolean completeCrossing(int bridgeSize) {
        if (bridgeSize == resultBridge.countCorrectCrossing()) {
            return true;
        }
        return false;
    }
}
