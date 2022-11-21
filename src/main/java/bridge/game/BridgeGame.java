package bridge.game;

import bridge.domain.bridge.Bridge;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.GameStatus;
import bridge.domain.history.History;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final Bridge bridge;
    private GameStatus gameStatus;
    private History history;

    public BridgeGame(Bridge madeBridge) {
        this.bridge = madeBridge;
        this.history = new History();
        this.gameStatus = GameStatus.RUNNING;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public History move(BridgePosition movePosition) {
        var surviveStatus = bridge.next(movePosition);

        this.history.record(surviveStatus, movePosition);
        this.gameStatus = GameStatus.generateGameStatus(surviveStatus, bridge);

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
        this.gameStatus = GameStatus.RUNNING;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
