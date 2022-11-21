package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private List<String> player;
    private int retryCount = 0;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        player = new ArrayList<>();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String movement) throws IllegalArgumentException{
        validate(movement);
        player.add(movement);
    }

    private void validate(String movement) {
        if (movement.equals("U") || movement.equals("D")) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 움직임은 U또는 D만 가능합니다.");
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player.clear();
        retryCount++;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public boolean isEnd() {
        return player.equals(bridge);
    }

    public boolean isMovableArea() {
        int currentIndex = player.size() - 1;

        return player.get(currentIndex).equals(bridge.get(currentIndex));
    }

    public List<String> getPlayer() {
        return player;
    }

    public List<String> getBridge() {
        return bridge;
    }
}

