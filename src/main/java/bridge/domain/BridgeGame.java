package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static final String UP_BRIDGE = "U";
    public static final String DOWN_BRIDGE = "D";

    private final List<String> bridge;
    private final Player player;
    private int tryCount;

    public BridgeGame(List<String> bridge, Player player) {
        this.bridge = bridge;
        this.player = player;
        tryCount = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        player.move(moving);
    }

    private boolean isSuccess() {
        String latestMoving = player.getLatestMoving();
        int position = player.getPosition();

        return bridge.get(position).equals(latestMoving);
    }

    public boolean isFinished() {
        int position = player.getPosition();

        return position == bridge.size() - 1;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
        player.reset();
    }

    public int getTryCount() {
        return tryCount;
    }
}
