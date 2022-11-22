package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private List<String> move;

    public BridgeGame(BridgeMaker bridgeMaker, int bridgeSize) {
        bridge = bridgeMaker.makeBridge(bridgeSize);
        move = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public Status move(String nextMove) {
        move.add(nextMove);
        if (bridge.get(move.size() - 1).equals(move.get(move.size() - 1)) == false) return Status.FAIL;
        if (bridge.size() == move.size()) return Status.COMPLETE;
        return Status.HAS_NEXT;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
