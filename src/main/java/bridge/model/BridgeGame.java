package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final int INITIAL_PLAY_COUNT = 1;

    private final Bridge bridge;
    private Player player;
    private int playCount;
    private boolean canPlay;

    public BridgeGame(List<String> bridge) {
        this.player = new Player();
        this.bridge = new Bridge(bridge);
        this.playCount = INITIAL_PLAY_COUNT;
        this.canPlay = true;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(Direction direction) {
        return bridge.cross(player.move(direction));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player = new Player();
        playCount++;
    }
}
