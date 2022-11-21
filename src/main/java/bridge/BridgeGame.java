package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<String> nowBridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.nowBridge = new ArrayList<>();
    }

    public static class MoveResult {
        public final List<String> nowBridge;
        public final int flag;

        public MoveResult(int flag, List<String> nowBridge) {
            this.flag = flag;
            this.nowBridge = nowBridge;
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(String userInput) {
        if (userInput.equals(bridge.get(nowBridge.size()))) {
            nowBridge.add(userInput);
            MoveResult moveResult = new MoveResult(1, nowBridge);
            return moveResult;
        }
        return new MoveResult(0, nowBridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
