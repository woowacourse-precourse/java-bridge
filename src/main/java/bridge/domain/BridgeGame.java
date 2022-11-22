package bridge.domain;

import java.util.List;

import static bridge.domain.Constants.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private BridgeState bridgeState;
    private BridgeGameState bridgeGameState;

    public BridgeGame(List<String> bridge, BridgeState bridgeState, BridgeGameState bridgeGameState) {
        this.bridge = bridge;
        this.bridgeState = bridgeState;
        this.bridgeGameState = bridgeGameState;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        bridgeState.mark(makeBridgeStatus(moving));
        updateGameResult(moving);
        bridgeGameState.countGameRound();
    }

    private void updateGameResult(String moving) {
        if (!isCrossable(moving)) {
            bridgeGameState.lose();
            return;
        }
        bridgeGameState.win();
    }

    private boolean isCrossable(String moving) {
        return moving.equals(bridge.get(bridgeGameState.getGameRound()));
    }

    private BridgeStatus makeBridgeStatus(String moving) {
        if (isCrossable(moving)) {
            return BridgeStatus.valueOfArrowAndMark(moving, O);
        }
        return BridgeStatus.valueOfArrowAndMark(moving, X);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (command.equals(RETRY)) {
            bridgeGameState.initGameRound();
            bridgeGameState.countTotalGameAttempts();
            bridgeState.initBridgeState();
            return true;
        }
        return false;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public int getTotalGameAttempts() {
        return bridgeGameState.getTotalGameAttempts();
    }

    public boolean isWon() {
        return bridgeGameState.isWon();
    }
}
