package bridge.game.bridgeGame;

import bridge.game.GameCommend;
import bridge.structure.Bridge;
import bridge.structure.BridgeMoveValue;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int INITIAL_TURN_COUNT = 1;

    private final Bridge bridge;
    private int turnCount;
    private BridgeGameStatus bridgeGameStatus;
    private BridgeGameResults bridgeResults;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.turnCount = INITIAL_TURN_COUNT;
        this.bridgeGameStatus = BridgeGameStatus.BEFORE_START;
        this.bridgeResults = new BridgeGameResults();
    }

    public BridgeGameStatus getBridgeGameStatus() {
        return bridgeGameStatus;
    }

    public BridgeGameResults getBridgeResults() {
        return bridgeResults;
    }
}
