package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<String> BridgeTrack;
    private int tryCount;

    public BridgeGame(List<String> bridge) {
        tryCount =1;
        this.bridge = bridge;
        BridgeTrack = new ArrayList<>();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input) {
        BridgeTrack.add(input);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        tryCount++;
    }
    public List<String> getBridgeTrack() {
        return new ArrayList<>(BridgeTrack);
    }
    public void reset() {
        BridgeTrack.clear();
    }
    public boolean isRecentMoveSuccessful() {
        int lastMoveIndex = BridgeTrack.size() - 1;
        return BridgeTrack.get(lastMoveIndex).equals(bridge.get(lastMoveIndex));
    }
    public int getTryCount() {
        return tryCount;
    }
}
