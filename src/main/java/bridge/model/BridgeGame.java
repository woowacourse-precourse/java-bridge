package bridge.model;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Player player;
    private final Bridge bridge;
    private TrialCount trialCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public void startGame() {
        player = new Player();
        trialCount = TrialCount.firstTrial();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Moving moving) {
        player.move(moving, bridge);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        trialCount = trialCount.increase();
        player = new Player();
    }

    public boolean isPlayable() {
        return player.isMoving();
    }

    public boolean isPlayerDead() {
        return player.isDead();
    }

    public Player getPlayer() {
        return player;
    }

    public TrialCount getTrialCount() {
        return trialCount;
    }
}
