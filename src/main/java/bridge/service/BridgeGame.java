package bridge.service;

import bridge.domain.result.BridgeResult;
import bridge.service.dto.MoveDto;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final static String CORRECT = "O";
    private final static String WRONG = "X";
    private final BridgeResult resultBridge;

    public BridgeGame(BridgeResult resultBridge) {
        this.resultBridge = resultBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(MoveDto moveDto, int blockPosition) {
        String block = moveDto.getBridge().getBlock(blockPosition);
        String blockToMove = moveDto.getInputHandler().getBlockToMove();

        if (blockToMove.equals(block)) {
            resultBridge.addBlock(blockToMove, CORRECT);
            return CORRECT;
        }
        resultBridge.addBlock(blockToMove, WRONG);
        return WRONG;
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
