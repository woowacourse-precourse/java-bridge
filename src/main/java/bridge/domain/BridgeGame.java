package bridge.domain;

import static bridge.constant.GameStatus.FAIL;
import static bridge.constant.GameStatus.ON_WAY;

import bridge.constant.GameStatus;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private GameStatus gameStatus;
    private int tryCount;
    private BridgeMover bridgeCalculator;
    private BridgeMonitor bridgeMonitor;

    public BridgeGame(List<String> bridge) {
        this.gameStatus = ON_WAY;
        this.tryCount = 1;
        this.bridgeCalculator = new BridgeMover(bridge);
        this.bridgeMonitor = new BridgeMonitor();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(String moving) {
        GameStatus gameStatusAfterMoving = this.bridgeCalculator.go(moving);
        this.gameStatus = gameStatusAfterMoving;
        this.bridgeMonitor.record(moving, gameStatusAfterMoving);
        return this.bridgeMonitor.getPicture();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
