package bridge.domain;

import bridge.BridgeMaker;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final String UPSIDE = "U";

    private List<String> bridge;
    private int currentTryIndex;
    private boolean isStopped;
    private List<CrossResult> topRoad;
    private List<CrossResult> downRoad;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.currentTryIndex = 0;
        this.isStopped = false;
        this.topRoad = new ArrayList<>();
        this.downRoad = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        if (canMove(direction)) {
            logResult(direction, CrossResult.SUCCESS);
            return ;
        }
        logResult(direction, CrossResult.FAILURE);
        isStopped = true;
    }

    private boolean canMove(String direction) {
        return bridge.get(currentTryIndex++) == direction;
    }

    private void logResult(String direction, CrossResult result) {
        if (isUpside(direction)) {
            topRoad.add(result);
            downRoad.add(CrossResult.PASS);
            return ;
        }
        topRoad.add(CrossResult.PASS);
        downRoad.add(result);
    }

    private boolean isUpside(String direction) {
        return direction == UPSIDE;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.currentTryIndex = 0;
        this.isStopped = false;
        this.topRoad = new ArrayList<>();
        this.downRoad = new ArrayList<>();
    }

    public boolean isEnd() {
        return currentTryIndex == bridge.size();
    }

    public boolean isStopped() {
        return isStopped;
    }
}
