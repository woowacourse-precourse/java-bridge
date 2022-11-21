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
     */
    public void move(String move) {
        route.add(move);
        ifFail(move);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        route.clear();
        status = StatusType.PLAY;
    }

    public void quit() {
        status = StatusType.FAIL;
    }

    public void isSuccess() {
        if (route.size() == answerBridge.size() && status.equals(StatusType.PLAY)) {
            status = StatusType.SUCCESS;
        }
    }

    private void ifFail(String move) {
        if (!answerBridge.get(route.size() - 1).equals(move)) {
            status = StatusType.FAIL;
        }
    }

    public StatusType getStatus() {
        return status;
    }

    public List<String> getRoute() {
        return route;
    }
}
