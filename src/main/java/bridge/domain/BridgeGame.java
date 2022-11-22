package bridge.domain;


import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int DEFAULT_VALUE = 0;
    private static final int MOVE_ON_NEXT = 1;
    private final List<String> bridge;
    private int location;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.location = DEFAULT_VALUE;
    }

    public List<String> getBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public int getLocation() {
        return location;
    }

    private void setLocation(int location) {
        this.location = location;
    }

    public boolean isPass(String moveUpOrDown) {
        return bridge.get(location).equals(moveUpOrDown);
    }

    public boolean isEndOfLocation() {
        return this.location == bridge.size();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        setLocation(this.location + MOVE_ON_NEXT);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        setLocation(DEFAULT_VALUE);
    }
}
