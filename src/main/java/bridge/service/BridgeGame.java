package bridge.service;

import bridge.model.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private GameStatus gameStatus;
    private TrialCount trialCount;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
    }

    public void initialize() {
        changeGameStatus(GameStatus.PLAY);
        trialCount = TrialCount.initialCount();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Player player, String moving) {
        player.move(Moving.toMoving(moving), bridge);
        if (player.isCrossedBridge()) {
            changeGameStatus(GameStatus.END);
        }
        if (player.isDead()) {
            changeGameStatus(GameStatus.PENDING);
        }
    }

    private void changeGameStatus(GameStatus newStatus) {
        gameStatus = newStatus;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(GameCommand command) {
        GameStatus newStatus = GameStatus.getGameStatusOf(command);
        changeGameStatus(newStatus);
        if (gameStatus.isPlay()) {
            trialCount = trialCount.increase();
        }
    }

    public boolean isContinuing() {
        return gameStatus.isPlay();
    }
}
