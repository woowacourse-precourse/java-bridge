package bridge.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.SurviveStatus;
import bridge.domain.history.History;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private History history;
    private SurviveStatus surviveStatus = SurviveStatus.SURVIVE;

    public BridgeGame(Bridge madeBridge) {
        this.bridge = madeBridge;
        this.history = new History();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public History move(BridgePosition movePosition) {
        this.surviveStatus = bridge.next(movePosition);
        history.record(surviveStatus, movePosition);
        return this.history;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.bridge.reset();
        this.history = new History();
        this.surviveStatus = SurviveStatus.SURVIVE;
    }

    public boolean canPlayerMove() {
        return surviveStatus.isAlive() && bridge.canMove();
    }

    public boolean isClear() {
        return surviveStatus.isAlive() && bridge.canNotMove();
    }
}
