package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeMaker bridgeMaker;
    private Player player;
    private GameStatistics gameStatistics;
    public BridgeGame(BridgeMaker bridgeMaker, Player player, GameStatistics gameStatistics) {
        this.bridgeMaker = bridgeMaker;
        this.player = player;
        this.gameStatistics = gameStatistics;
    }

    public BridgeMaker getBridgeMaker() {
        return bridgeMaker;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moveDirection, List<String> roadMap, Player player) {
        player.moveStraight();
        return roadMap.get(player.getCurrentLocation()).equals(moveDirection);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void constructBridge() {
        gameStatistics.getCheckRoad()
    }

    public Player getPlayer() {
        return player;
    }
}
