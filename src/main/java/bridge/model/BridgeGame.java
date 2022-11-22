package bridge.model;

import bridge.BridgeMaker;
import bridge.model.domains.Player;
import bridge.model.domains.RemainingSteps;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private Player player;
    private int trialCount;

    public BridgeGame(int bridgeSize, BridgeMaker bridgeMaker) throws IllegalArgumentException, NullPointerException {
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        this.player = new Player(new RemainingSteps(bridge));
        this.trialCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용한다.
     */
    public void move(String moving) throws IllegalStateException {
        player.addOneMoving(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용한다.
     */
    public void retry() {
        refreshGameStatus();
    }

    private void refreshGameStatus() {
        player = new Player(new RemainingSteps(bridge));
        validateTrialCount();
        this.trialCount++;
    }

    private void validateTrialCount() {
        if (trialCount == Integer.MAX_VALUE) {
            throw new IllegalStateException("재시도 횟수가 너무 많아 더 이상 게임을 진행할 수 없습니다.");
        }
    }

    public boolean hasAllMovingDone() {
        return player.hasAllMovingDone();
    }

    public boolean hasPlayerFailed() {
        return player.isFailed();
    }

    public int getTrialCount() {
        return trialCount;
    }
}
