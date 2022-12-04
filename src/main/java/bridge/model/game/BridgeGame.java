package bridge.model.game;

import bridge.model.status.RoundStatus;
import bridge.model.bridge.BridgeDirection;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final GameVariable gameVariable;

    public BridgeGame(GameVariable gameVariable) {
        this.gameVariable = gameVariable;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public RoundStatus move(BridgeDirection bridgeDirection, BridgeDirection playerDirection) {
        boolean isRoundSuccess = BridgeDirection.isSame(bridgeDirection, playerDirection);
        RoundStatus roundStatus = RoundStatus.from(isRoundSuccess);
        gameVariable.updateMaps(playerDirection, roundStatus);
        return roundStatus;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameVariable.addAttempts();
        gameVariable.initializeMaps();
    }
}
