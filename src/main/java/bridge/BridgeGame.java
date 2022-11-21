package bridge;

import static bridge.Constant.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public final List<String> bridge;
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
        nowBridge.add(userInput);
        if (userInput.equals(bridge.get(nowBridge.size() - 1))) {
            if(nowBridge.size() == bridge.size()) {
                return new MoveResult(MOVERESULT_FLAG_FULL, nowBridge);
            }
            return new MoveResult(MOVERESULT_FLAG_VALID, nowBridge);
        }
        return new MoveResult(MOVERESULT_FLAG_INVALID, nowBridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(String userInput) {
        if (userInput.equals(RETRY_USER_YES)) {
            nowBridge.clear();
            return RETRY_FLAG_YES;
        }
        return RETRY_FLAG_NO;
    }
}
