package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int TRIES_INIT = 1;
    private final List<String> bridge;
    private List<String> crossedBridge;
    private int tries;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.crossedBridge = new ArrayList<>();
        this.tries = TRIES_INIT;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direction) {
        crossedBridge.add(direction);
        return bridge.get(crossedBridge.size() - 1).equals(direction);
    }

    public List<String> getCrossedBridge() {
        return this.crossedBridge;
    }

    public int getTries() {
        return this.tries;
    }

    public boolean isMapSizeSameWith(int size) {
        return bridge.size() == size;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        crossedBridge = new ArrayList<>();
        tries = tries + 1;
    }
}
