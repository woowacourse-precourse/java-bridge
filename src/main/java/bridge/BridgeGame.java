package bridge;

import java.util.ArrayList;
import java.util.List;
/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> route = new ArrayList<>();
    private List<String> answerBridge;
    private StatusType status;

    public BridgeGame(List<String> answerBridge) {
        this.route = new ArrayList<>();
        this.answerBridge = answerBridge;
        this.status = StatusType.PLAY;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String move) {
        route.add(move);
        ifFail(move);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private void ifFail(String move) {
        if (!answerBridge.get(route.size() - 1).equals(move)) {
            status = StatusType.FAIL;
        }
    }

    public StatusType getStatus() {
        return status;
    }
}
