package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Player player;
    private List<String> bridge;
    private int numberOfAttempts;

    public BridgeGame() {
        numberOfAttempts = 0;
    }

    private void increaseNumberOfAttempts() {
        numberOfAttempts++;
    }

    public void initializeBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public void createNewPlayer() {
        player = new Player();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        player.move(direction);
    }

    public List<String> getCurrentUpperMap() {
        return player.getCurrentMap(bridge, Direction.UP);
    }

    public List<String> getCurrentLowerMap() {
        return player.getCurrentMap(bridge, Direction.DOWN);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
