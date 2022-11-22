package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Player player;
    private GameStatistics gameStatistics;
    private Bridge bridge;

    public BridgeGame(Player player, Bridge bridge) {
        this.player = player;
        this.gameStatistics = bridge.getGameStatistics();
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String moveDirection, List<String> roadMap, Player player) {
        player.moveForward();
        return roadMap.get(Player.currentLocation).equals(moveDirection);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        gameStatistics.increaseTotalTryCount();
        bridge.resetBridge();
        player.initCurrentLocation();
        gameStatistics.initCheckRoad();
    }

    public Player getPlayer() {
        return player;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public GameStatistics getGameStatistics() {
        return gameStatistics;
    }
}
