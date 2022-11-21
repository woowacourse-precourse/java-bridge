package bridge.domain;

import java.util.List;

import static bridge.domain.Constants.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;
    private BridgeState bridgeState;
    private int round = BRIDGE_GAME_ROUND_INIT;
    private int totalGameAttempts = BRIDGE_GAME_ATTEMPTS_INIT;
    private boolean gameResult = BRIDGE_GAME_RESULT_INIT;

    public BridgeGame(List<String> bridge, BridgeState bridgeState) {
        this.bridge = bridge;
        this.bridgeState = bridgeState;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String arrow) {
        bridgeState.mark(makeBridgeStatus(arrow));
        updateGameResult(arrow);
        round++;
    }

    private void updateGameResult(String arrow) {
        if (!isCrossable(arrow)) {
            gameResult = false;
            return;
        }
        gameResult = true;
    }

    private boolean isCrossable(String arrow) {
        return arrow.equals(bridge.get(round));
    }

    private BridgeStatus makeBridgeStatus(String arrow) {
        if (isCrossable(arrow)) {
            return BridgeStatus.valueOfArrowAndMark(arrow, O);
        }
        return BridgeStatus.valueOfArrowAndMark(arrow, X);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        if (command.equals(RETRY)) {
            round = 0;
            totalGameAttempts++;
            bridgeState.initBridgeState();
            return true;
        }
        return false;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public int getTotalGameAttempts() {
        return totalGameAttempts;
    }

    public boolean isWon() {
        return gameResult;
    }
}
