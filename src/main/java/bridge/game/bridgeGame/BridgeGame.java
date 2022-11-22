package bridge.game.bridgeGame;

import bridge.game.GameCommand;
import bridge.structure.Bridge;
import bridge.structure.BridgeMoveValue;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final int INITIAL_TURN_COUNT = 1;
    private final int ADJUST_TURN_COUNT = -1;


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

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(BridgeMoveValue bridgeMoveValue) {
        if (bridge.canGo(bridgeMoveValue, this.turnCount + ADJUST_TURN_COUNT)) {
            addBridgeResult(bridgeMoveValue, true);
            isMoveAll();
            return;
        }

        addBridgeResult(bridgeMoveValue, false);
        this.bridgeGameStatus = BridgeGameStatus.FALL;
    }

    private void addBridgeResult(BridgeMoveValue bridgeMoveValue, boolean pass) {
        this.bridgeResults.add(new BridgeGameResult(bridgeMoveValue, pass));
    }

    private void isMoveAll() {
        if (this.bridge.getBridge()
                .size() == this.turnCount) {
            this.bridgeGameStatus = BridgeGameStatus.CORRECT;
            return;
        }
        this.turnCount++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(GameCommand gameCommand) {
        if (GameCommand.isRestart(gameCommand)) {
            initializeMember();
            return true;
        }
        return false;
    }

    private void initializeMember() {
        this.turnCount = INITIAL_TURN_COUNT;
        this.bridgeGameStatus = BridgeGameStatus.BEFORE_START;
        this.bridgeResults = new BridgeGameResults();
    }

}
