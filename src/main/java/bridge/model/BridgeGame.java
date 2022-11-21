package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private Player player;
    private Bridge bridge;

    public BridgeGame(List<String> bride) {
        this.player = new Player();
        this.bridge = new Bridge(bride);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String movingCommand) {
        player.addMovingSpaces(movingCommand);
    }

    public boolean isCanCross() {
        int idx = player.getMovingSpacesSize()-1;
        return player.getMovingSpaces().get(idx).equals(bridge.getBridge().get(idx));
    }

    public boolean isGameSuccess() {
        return player.getMovingSpacesSize() == bridge.getBrideSize();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player.resetPlayer();
        player.addAttempt();
    }

    public void failGame() {
        player.playerIsFail();
    }

    public Player getPlayer() {
        return player;
    }

    public Bridge getBridge() {
        return bridge;
    }
}
