package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.domains.Player;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private Player player;
    private int trialCount;

    public BridgeGame(int bridgeSize) {
        // TODO BridgeMaker 직접 생성하는 대신 주입받기
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        this.player = new Player(bridge);
        this.trialCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        player.addOneMoving(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        refreshGameStatus();
    }

    private void refreshGameStatus() {
        player = new Player(bridge);
        this.trialCount++;
    }


    public List<String> getPlayerMovingHistory() {
        return player.getMovingHistory();
    }

    public boolean hasPlayerFailed() {
        return player.isFailed();
    }

    public boolean hasAllMovingDone() {
        return player.hasAllMovingDone();
    }

    public int getTrialCount() {
        return trialCount;
    }
}
