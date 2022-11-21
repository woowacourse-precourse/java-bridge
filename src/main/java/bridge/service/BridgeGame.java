package bridge.service;

import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final BridgeResult resultBridge;

    public BridgeGame(Bridge bridge, BridgeResult resultBridge) {
        this.bridge = bridge;
        this.resultBridge = resultBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String blockToMove, int blockPosition, int bridgeSize) {
        String block = bridge.getBlock(blockPosition);

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

    public List<String> makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge.setBridge(bridgeMaker.makeBridge(bridgeSize));

        return bridge.getBridge();
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
